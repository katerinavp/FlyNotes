package com.petukhova.flynotes.Repository;

import androidx.annotation.Nullable;
import com.petukhova.flynotes.DeadlineComparator;
import com.petukhova.flynotes.ItemData;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileNoteRepository implements NoteRepository {

    private List<ItemData> items = Collections.emptyList();
    private final Comparator<ItemData> deadlineComparator = new DeadlineComparator();
    private final Gson gson = new Gson();
    private final File notesFile;

    public FileNoteRepository(File notesFile) {
        this.notesFile = notesFile;
        readAll();
        sort();
    }

    @Nullable
    @Override
    public ItemData getNoteById(int id) {
        if (items == null) {
            return null;
        }
        for (ItemData item : items) {
            if (item.getNoteId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<ItemData> getNotes() {
        return items;
    }

    @Override
    public void saveNote(String title, String note, String deadline) {
        int id;
        if (items.isEmpty()) {
            id = 0;
        } else {
            id = items.get(items.size() - 1).getNoteId() + 1;
        }
        final ItemData itemData = new ItemData(id, title, note, deadline);
        items.add(itemData);
        final File noteFile = new File(notesFile, String.valueOf(id));
        saveItemToFile(itemData, noteFile);
        sort();
    }

    @Override
    public void deleteById(int id) {
        items.removeIf(itemData -> itemData.getNoteId() == id);
        //noinspection ResultOfMethodCallIgnored
        new File(notesFile, String.valueOf(id)).delete();
        sort();
    }

    private void sort() {
        Collections.sort(items, deadlineComparator);
        int i = 0;
        for (ItemData item : items) {
            items.set(i, new ItemData(i, item.getTitle(), item.getNote(), item.getDeadline()));
            i++;
        }
    }

    public void update(int id, String title, String note, String deadline) {
        final ItemData itemData = new ItemData(id, title, note, deadline);
        items.set(id, itemData);
        //noinspection ResultOfMethodCallIgnored
        new File(notesFile, String.valueOf(id)).delete();
        final File noteFile = new File(notesFile, String.valueOf(id));
        saveItemToFile(itemData, noteFile);
        sort();
    }

    private void saveItemToFile(ItemData itemData, File noteFile) {
        try (PrintWriter writer = new PrintWriter(noteFile)) {
            writer.print(gson.toJson(itemData));
        } catch (IOException e) {
            // do nothing
        }
    }

    private void readAll() {
        final String[] files = notesFile.list();
        if (files == null) {
            items = new ArrayList<>();
            return;
        }

        items = new ArrayList<>(files.length);
        for (String fileName: files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(new File(notesFile, fileName)))) {
                ItemData item = gson.fromJson(reader.readLine(), ItemData.class);
                items.add(item);
            } catch (IOException e) {
                // do nothing
            }
        }
    }
}

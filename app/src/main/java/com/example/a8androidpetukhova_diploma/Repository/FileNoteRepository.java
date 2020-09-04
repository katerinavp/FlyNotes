package com.example.a8androidpetukhova_diploma.Repository;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a8androidpetukhova_diploma.DeadlineComparator;
import com.example.a8androidpetukhova_diploma.ItemData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileNoteRepository implements NoteRepository {

    final static String TEXT_VIEW_TEXT_KEY = "TEXTVIEW_TEXT";
    private NoteDao noteDao;
    private List<ItemData> items;
    private final Comparator<ItemData> deadlineComparator = new DeadlineComparator();
    Gson gson;
    String jsonString;

    public FileNoteRepository(List<ItemData> items) {
        this.items = items;

    }

    public void NoteRep(Application application) {
        AppDatabase database = AppDatabase.getDatabase(application);
        noteDao = database.getNoteDao();
        items = noteDao.getAllNote();
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

        items.add(new ItemData(id, title, note, deadline));


    }

    @Override
    public void deleteById(int id) {
        items.removeIf(itemData -> itemData.getNoteId() == id);
        // sort();
        // Collections.sort(items, deadlineComparator);
    }

    public void update(int id, String title, String note, String deadline) {
        items.set(id, new ItemData(id, title, note, deadline));

    }

    public void sort() {
        Collections.sort(items, deadlineComparator);

    }

    public void makeNewId() {
        int i = 0;

        for (ItemData item : items) {

            items.set(i, new ItemData(i, item.getTitle(), item.getNote(), item.getDeadline()));
            i++;
        }
        convertToGson();
    }


    public void convertToGson() {
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
        jsonString = gson.toJson(items);
        Log.i("GSON", gson.toJson(items));
        Log.i("GSON", jsonString);

    }

    public void convertFromGson() {
        int i = 0;
        Gson gson = new Gson();
        List<ItemData> itemsJson = gson.fromJson(jsonString, new TypeToken<List<ItemData>>() {
        }.getType());
        for (ItemData itemJson : itemsJson) {
            items.set(i, itemJson);
            Log.i("fromGSONi", itemJson.toString());
            i++;
        }

    }

//    public static boolean isJson(String Json) {
//        try {
//            new JSONObject(Json);
//        } catch (JSONException ex) {
//            try {
//                new JSONArray(Json);
//            } catch (JSONException ex1) {
//                return false;
//            }
//        }
//        return true;
//    }


}

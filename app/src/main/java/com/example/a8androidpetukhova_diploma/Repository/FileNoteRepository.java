package com.example.a8androidpetukhova_diploma.Repository;

import androidx.annotation.Nullable;

import com.example.a8androidpetukhova_diploma.ItemData;

import java.util.List;

import static com.example.a8androidpetukhova_diploma.Activity.NotesActivity.adapter;

public class FileNoteRepository implements NoteRepository {
    private List<ItemData> items;
    private ItemData id;

    public FileNoteRepository(List<ItemData> items) {
        this.items = items;
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
            System.out.println("Размер size после удаления заметки  " + items.size());
            System.out.println("Размер size АДАПТЕРА после удаления заметки  " + adapter.getCount());

            id = items.get(items.size() - 1).getNoteId() + 1;

            System.out.println("Размер id после добавления  " + id);
        }

        this.items.add(new ItemData(id, title, note, deadline));
        System.out.println("Размер коллекции равен " + items.size());
    }

//        int id;
//        if (!items.isEmpty()) {
//            System.out.println("Размер size после удаления заметки  " + items.size());
//            System.out.println("Размер size АДАПТЕРА после удаления заметки  " + adapter.getCount());
//            //for (int i = 0; i <= items.size() - 1; i++) {
//                id = items.get(items.size() - 1).getNoteId() + 1;
//
//                System.out.println("Размер id после добавления  " + id);
//
//                this.items.add(new ItemData(id, title, note, deadline));
//                System.out.println("Размер коллекции равен " + items.size());
//
//
//        } else {
//            id = 0;
//            this.items.add(new ItemData(id, title, note, deadline));
//            System.out.println("Размер коллекции равен " + items.size());
//        }
//
//}


    @Override
    public void deleteById(int id) {
        items.removeIf(itemData -> itemData.getNoteId() == id);

        System.out.println("Размер коллекции после удаления заметки равен " + items.size());
        System.out.println("Обновленный id " + id);
        //id = items.get(items.size() - 1).getNoteId() + 1;
    }


}

package com.example.a8androidpetukhova_diploma.Repository;

import com.example.a8androidpetukhova_diploma.ItemData;

import java.util.List;

public class FileNoteRepository implements NoteRepository {
    private List<ItemData> items;
    private ItemData id;

    public FileNoteRepository(List<ItemData> items) {
        this.items = items;
    }

    @Override
    public ItemData getNoteById(int id) {
        System.out.println("Получаем id " + id);
        return this.id;
    }

    @Override
    public List<ItemData> getNotes() {
        return items;
    }

    @Override
    public void saveNote(ItemData item) {
        this.items.add(item);
    }

    @Override
    public void deleteById(int id) {
        items.remove(id);
    }
}

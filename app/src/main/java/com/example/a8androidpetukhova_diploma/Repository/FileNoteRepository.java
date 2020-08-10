package com.example.a8androidpetukhova_diploma.Repository;

import com.example.a8androidpetukhova_diploma.ItemData;

import java.util.List;

public class FileNoteRepository implements NoteRepository {
    private List<ItemData> items;
    String id = "";

    public FileNoteRepository(List<ItemData> items) {
        this.items = items;
    }

    @Override
    public String getNoteById(String id) {
        System.out.println("Получаем id " + id);
        return id;
    }

    @Override
    public List<ItemData> getNotes() {
        return items;
    }


    @Override
    public void saveNote(ItemData item) {
        this.items.add(item);
        System.out.println("Сохранены данные  в репозиторий " + items);

    }

    @Override
    public void deleteById(String id) {
        items.remove(id);

    }
}

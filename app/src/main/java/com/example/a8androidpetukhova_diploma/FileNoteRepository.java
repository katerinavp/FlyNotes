package com.example.a8androidpetukhova_diploma;

import java.util.List;

public class FileNoteRepository implements NoteRepository {
    private List<ItemData> items;

    public FileNoteRepository(List<ItemData> items) {
        this.items = items;
    }

    @Override
    public String getNoteById(String id) {
        return id;
    }

    @Override
    public List<ItemData> getNotes() {


        return items;
    }


    @Override
    public void saveNote(ItemData item) {

    }

    @Override
    public void deleteById(String id) {

    }
}

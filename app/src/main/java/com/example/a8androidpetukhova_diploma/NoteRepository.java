package com.example.a8androidpetukhova_diploma;


import java.util.List;


public interface NoteRepository {

    String getNoteById(String id);
    List<ItemData> getNotes();
    void saveNote(ItemData items);
    void deleteById(String id);
}


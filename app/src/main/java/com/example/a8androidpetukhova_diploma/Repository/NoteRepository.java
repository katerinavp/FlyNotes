package com.example.a8androidpetukhova_diploma.Repository;


import com.example.a8androidpetukhova_diploma.ItemData;

import java.util.List;


public interface NoteRepository {

    ItemData getNoteById(int id);
    List<ItemData> getNotes();
    void saveNote(ItemData items);
    void deleteById(int id);
}


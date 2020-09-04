package com.example.a8androidpetukhova_diploma.Repository;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a8androidpetukhova_diploma.ItemData;

import java.io.FileNotFoundException;
import java.util.List;


public interface NoteRepository {

    @Nullable
    ItemData getNoteById(int id);

    List<ItemData> getNotes();

    void saveNote(String title, String note, String deadline);

    void deleteById(int id);

    void update(int id, String title, String note, String deadline);

    void sort();

    void makeNewId();

    void convertFromGson();

}


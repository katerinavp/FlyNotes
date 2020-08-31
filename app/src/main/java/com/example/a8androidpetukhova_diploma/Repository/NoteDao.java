package com.example.a8androidpetukhova_diploma.Repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.a8androidpetukhova_diploma.ItemData;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insertNote(ItemData itemdata);

    @Delete
    void deleteNote(ItemData itemdata);

    @Update
    void updateNote(ItemData itemdata);

    @Query("SELECT * FROM itemdata")
    List<ItemData> getAllNote();

    @Query("SELECT * FROM itemdata WHERE noteId = :id")
    ItemData getById(int id);
}

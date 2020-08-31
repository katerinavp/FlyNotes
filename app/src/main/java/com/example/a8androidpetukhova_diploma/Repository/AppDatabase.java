package com.example.a8androidpetukhova_diploma.Repository;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.a8androidpetukhova_diploma.ItemData;

@Database(entities = {ItemData.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract NoteDao getNoteDao();

    //public abstract NoteDao noteDao();

    public static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class,
                                    "note_database").build();
                }
            }
        }
        return INSTANCE;
    }
}


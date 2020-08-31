package com.example.a8androidpetukhova_diploma;
import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.a8androidpetukhova_diploma.Repository.AppDatabase;
import com.example.a8androidpetukhova_diploma.Key.Keystore;
import com.example.a8androidpetukhova_diploma.Key.SimpleKeystore;
import com.example.a8androidpetukhova_diploma.Repository.FileNoteRepository;
import com.example.a8androidpetukhova_diploma.Repository.NoteRepository;
import java.util.ArrayList;

public class App extends Application {

    private static Keystore keystore;
    private static NoteRepository noteRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        keystore = new SimpleKeystore(getSharedPreferences("password_text", Context.MODE_PRIVATE));
        noteRepository = new FileNoteRepository(new ArrayList<>());

    }

    public static Keystore getKeystore() {
        return keystore;
    }

    public static NoteRepository getNoteRepository() {
        return noteRepository;
    }

}

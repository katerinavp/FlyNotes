package com.petukhova.flynotes;

import android.app.Application;
import android.content.Context;
import com.petukhova.flynotes.Key.Keystore;
import com.petukhova.flynotes.Key.SimpleKeystore;
import com.petukhova.flynotes.Repository.FileNoteRepository;
import com.petukhova.flynotes.Repository.NoteRepository;

import java.io.File;

public class App extends Application {

    private static Keystore keystore;
    private static NoteRepository noteRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        keystore = new SimpleKeystore(getSharedPreferences("password_text", Context.MODE_PRIVATE));
        final File notesRoot = new File(getFilesDir(), "notes");
        //noinspection ResultOfMethodCallIgnored
        notesRoot.mkdir();
        noteRepository = new FileNoteRepository(notesRoot);

    }

    public static Keystore getKeystore() {
        return keystore;
    }

    public static NoteRepository getNoteRepository() {
        return noteRepository;
    }

}

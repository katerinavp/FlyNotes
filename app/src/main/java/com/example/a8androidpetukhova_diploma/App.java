package com.example.a8androidpetukhova_diploma;

import android.app.Application;
import android.content.Context;
import com.example.a8androidpetukhova_diploma.Key.Keystore;
import com.example.a8androidpetukhova_diploma.Key.SimpleKeystore;
import com.example.a8androidpetukhova_diploma.Repository.FileNoteRepository;
import com.example.a8androidpetukhova_diploma.Repository.NoteRepository;
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

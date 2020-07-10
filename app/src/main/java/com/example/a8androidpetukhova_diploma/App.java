package com.example.a8androidpetukhova_diploma;
import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static Keystore keystore;
    private static NoteRepository noteRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        keystore = new SimpleKeystore(getSharedPreferences("password_text", Context.MODE_PRIVATE));
//        noteRepository = new FileNoteRepository(this);

    }

    public static Keystore getKeystore() {
        return keystore;
    }

}

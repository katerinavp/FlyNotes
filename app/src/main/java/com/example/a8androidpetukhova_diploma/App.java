package com.example.a8androidpetukhova_diploma;
import android.app.Application;
import android.content.Context;

import com.example.a8androidpetukhova_diploma.Key.Keystore;
import com.example.a8androidpetukhova_diploma.Key.SimpleKeystore;
import com.example.a8androidpetukhova_diploma.Repository.FileNoteRepository;
import com.example.a8androidpetukhova_diploma.Repository.NoteRepository;

import java.util.ArrayList;
//import dagger.hilt.android.HiltAndroidApp;

//@HiltAndroidApp //Этот сгенерированный компонент Hilt присоединяется к Applicationжизненному циклу объекта и обеспечивает для него зависимости.
// Кроме того, это родительский компонент приложения, что означает, что другие компоненты могут получить доступ к зависимостям, которые оно предоставляет.

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

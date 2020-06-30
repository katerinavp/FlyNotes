package com.example.a8androidpetukhova_diploma;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
;


public class NotesActivity extends AppCompatActivity {

    private TextView textView = null;
    private StringBuilder text = new StringBuilder();

    private static ItemsDataAdapter adapter;
    ListView list;
    static List<String> titles = new ArrayList<>();
    static List<String> notes = new ArrayList<>();
    static List<String> deadlines = new ArrayList<>();
    final String LOG_TAG = "myLogs";
    private static SharedPreferences myNoteSharedPref;
    private static String NOTE_TEXT = "note_text";
    private static String NOTE_TITLE = "note_title";
    private static String NOTE_NOTES = "note_note";
    private static String NOTE_DEAD = "note_deadline";

    Boolean FirstStart;
    Boolean NextAct;
    ActivityManager am;
    List<ActivityManager.RunningTaskInfo> listExample;
    // private List<Map<String, String>> result = new ArrayList<>();
    // private ArrayAdapter<String> arrayAdapter;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        Toolbar toolbar = findViewById(R.id.toolbar_notes);
//        setSupportActionBar(toolbar);
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setTitle("Заметки");
//
//        }
//
//        initNotes();
//        setOnClickAddNewNotes();
//        deleteNote();
//    }
//
////    @Override
////    protected void onSaveInstanceState(Bundle outState) {
////        outState.putStringArrayList("titles", (ArrayList<String>) titles);
////        outState.putStringArrayList("notes", (ArrayList<String>) notes);
////        outState.putStringArrayList("deadlines", (ArrayList<String>) deadlines);
////        super.onSaveInstanceState(outState);
////    }
////
////    @Override
////    protected void onRestoreInstanceState(Bundle savedInstanceState) {
////        super.onRestoreInstanceState(savedInstanceState);
////
////        titles = savedInstanceState.getStringArrayList("titles");
////        notes = savedInstanceState.getStringArrayList("notes");
////        deadlines = savedInstanceState.getStringArrayList("deadlines");
////        for (int i = 0; i <= titles.size() - 1; i++) {
////            adapter.addItem(new ItemData(titles.get(i), notes.get(i),
////                    deadlines.get(i)));
////            adapter.notifyDataSetChanged();
////        }
////
////    }
//
//    public void initNotes() {
//        list = findViewById(R.id.list);
//        adapter = new ItemsDataAdapter(this, null);
//        list.setAdapter(adapter);
//    }
//
//    public void deleteNote() {
//        // При долгом тапе по элементу списка будем удалять его
//        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                adapter.removeItem(position);
//                return true;
//            }
//        });
//    }
//
////    @NonNull
////    private void createAdapter() {
////        adapter = new ItemsDataAdapter(this, null);
////        list.setAdapter(adapter);
////        SimpleAdapter simpleAdapter  = new SimpleAdapter(this, fakeMaps, R.layout.simple_list_item, // S.A. Принимает context (MainActivivty - this с помощью контекста мы получем доступ к ресурсу),
////                //список словарей - fakeMaps, ресурс ссылка  layout строки - simple_list_item с двумя TextView (два ключа),
////                // откуда ему брать view -
////                new String[]{KEY_1, KEY_2}, new int[]{R.id.oneTxtv, R.id.twoTxtv});
////    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) { //загрузка меню
//        getMenuInflater().inflate(R.menu.menu_notes, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) { // обработка кнопки menuSetup
//        switch (item.getItemId()) {
//            case R.id.menuSetup:
//                Intent intentSetup = new Intent(NotesActivity.this, SetupActivity.class);
//                startActivity(intentSetup);
//                return true;
//
////            case android.R.id.:
////                Intent intentNotes = new Intent(SetupActivity.this, NotesActivity.class);
////                startActivity(intentNotes);
////                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    private void setOnClickAddNewNotes() {
//        findViewById(R.id.add_new_notes).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intentFromNotesToNewNotes = new Intent(NotesActivity.this, NewNoteActivity.class);
//
//                startActivityForResult(intentFromNotesToNewNotes, 20);
//            }
//        });
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (data == null) {
//            return;
//        }
//        String title = data.getStringExtra("title");
//        String note = data.getStringExtra("note");
//        String deadline = data.getStringExtra("deadline");
//        System.out.println("ЗАГОЛОВОК И ЗАПИСКА " + title + " " + note + " " + deadline);
//        generateItemData(title, note, deadline);
//    }
//
//    public static void generateItemData(String title, String note, String deadline) {
//        titles.add(title);
//        notes.add(note);
//        deadlines.add(deadline);
//        System.out.println("Данные сформированы " + titles + " " + notes + " " + deadlines);
//        int index = (titles.size() - 1);
//        // int index = 0;
//        adapter.addItem(new ItemData(titles.get(index), notes.get(index),
//                deadlines.get(index)));
//    }
//
//}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        Log.d(LOG_TAG, "onCreate ");

        Toolbar toolbar = findViewById(R.id.toolbar_notes);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Заметки");

        if (!titles.isEmpty() || notes.isEmpty() || deadlines.isEmpty()) {
                System.out.println(titles.toString());
                System.out.println(notes.toString());
                System.out.println(deadlines.toString());
            }
            System.out.println("Вывод данных ");
            for (int i = 0; i <= titles.size() - 1; i++) {
                adapter.addItem(new ItemData(titles.get(i), notes.get(i),
                        deadlines.get(i)));
                adapter.notifyDataSetChanged();
            }
           
            initNotes();
            setOnClickAddNewNotes();
            deleteNote();


        } else {
            initNotes();
            setOnClickAddNewNotes();
            deleteNote();
        }
//        Toolbar toolbar = findViewById(R.id.toolbar_notes);
//        setSupportActionBar(toolbar);
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setTitle("Заметки");
//
//            System.out.println(titles.toString());
//            System.out.println(notes.toString());
//            System.out.println(deadlines.toString());
//        }
//        if (myNoteSharedPref.contains(NOTE_TEXT)) {
//            Toast.makeText(NotesActivity.this, "Shared Существует", Toast.LENGTH_LONG).show();
////            titles = savedInstanceState.getStringArrayList("titles");
////            notes = savedInstanceState.getStringArrayList("notes");
////            deadlines = savedInstanceState.getStringArrayList("deadlines");
//            for (int i = 0; i <= titles.size() - 1; i++) {
//                adapter.addItem(new ItemData(titles.get(i), notes.get(i),
//                        deadlines.get(i)));
//                adapter.notifyDataSetChanged();
//            }
//            initNotes();
//            setOnClickAddNewNotes();
//            deleteNote();
//        } else {
//        if (savedInstanceState != null) {
//            Toast.makeText(NotesActivity.this, "saveInstanceState !== null", Toast.LENGTH_LONG).show();
//            titles = savedInstanceState.getStringArrayList("titles");
//            notes = savedInstanceState.getStringArrayList("notes");
//            deadlines = savedInstanceState.getStringArrayList("deadlines");
//            for (int i = 0; i <= titles.size() - 1; i++) {
//                adapter.addItem(new ItemData(titles.get(i), notes.get(i),
//                        deadlines.get(i)));
//                adapter.notifyDataSetChanged();
//            }

//        if(!titles.isEmpty() || notes.isEmpty() || deadlines.isEmpty()) {
////            titles = savedInstanceState.getStringArrayList("titles");
////            notes = savedInstanceState.getStringArrayList("notes");
////            deadlines = savedInstanceState.getStringArrayList("deadlines");
//            for (int i = 0; i <= titles.size() - 1; i++) {
//                adapter.addItem(new ItemData(titles.get(i), notes.get(i),
//                        deadlines.get(i)));
//                adapter.notifyDataSetChanged();
//            }

//            initNotes();
//            setOnClickAddNewNotes();
//            deleteNote();


//        } else {
//            Toast.makeText(NotesActivity.this, "saveInstanceState == null", Toast.LENGTH_LONG).show();

//            initNotes();
//            setOnClickAddNewNotes();
//            deleteNote();

    }


    public void initNotes() {
        list = findViewById(R.id.list);
        adapter = new ItemsDataAdapter(this, null);
        list.setAdapter(adapter);
    }

    public void deleteNote() {
        // При долгом тапе по элементу списка будем удалять его
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.removeItem(position);
                return true;
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);

        outState.putStringArrayList("titles", (ArrayList<String>) titles);
        outState.putStringArrayList("notes", (ArrayList<String>) notes);
        outState.putStringArrayList("deadlines", (ArrayList<String>) deadlines);
        Log.d(LOG_TAG, "onSaveInstanceState ");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(LOG_TAG, "onRestoreInstanceState ");
        titles = savedInstanceState.getStringArrayList("titles");
        notes = savedInstanceState.getStringArrayList("notes");
        deadlines = savedInstanceState.getStringArrayList("deadlines");
        for (int i = 0; i <= titles.size() - 1; i++) {
            adapter.addItem(new ItemData(titles.get(i), notes.get(i),
                    deadlines.get(i)));
            adapter.notifyDataSetChanged();
            Log.d(LOG_TAG, "onRestoreInstanceState ");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //загрузка меню
        getMenuInflater().inflate(R.menu.menu_notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // обработка кнопки menuSetup
        switch (item.getItemId()) {
            case R.id.menuSetup:
                Intent intentSetup = new Intent(NotesActivity.this, SetupActivity.class);
                startActivity(intentSetup);
                return true;

//            case android.R.id.:
//                Intent intentNotes = new Intent(SetupActivity.this, NotesActivity.class);
//                startActivity(intentNotes);
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void setOnClickAddNewNotes() {
        findViewById(R.id.add_new_notes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentFromNotesToNewNotes = new Intent(NotesActivity.this, NewNoteActivity.class);

                startActivityForResult(intentFromNotesToNewNotes, 20);
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        String title = data.getStringExtra("title");
        String note = data.getStringExtra("note");
        String deadline = data.getStringExtra("deadline");

        System.out.println("ЗАГОЛОВОК И ЗАПИСКА " + title + " " + note + " " + deadline);
        generateItemData(title, note, deadline);
    }

    public void generateItemData(String title, String note, String deadline) {
        titles.add(title);
        notes.add(note);
        deadlines.add(deadline);
        System.out.println("Данные сформированы " + titles + " " + notes + " " + deadlines);
        int index = (titles.size() - 1);
        // int index = 0;
        adapter.addItem(new ItemData(titles.get(index), notes.get(index),
                deadlines.get(index)));


    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart ");


    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume ");
//        if (!NOTE_TITLE.isEmpty() || !NOTE_NOTES.isEmpty() || !NOTE_DEAD.isEmpty()) {
//            List<String> notesShList = new ArrayList<>();
//            List<String> titlesShList = new ArrayList<>();
//            List<String> deadShList = new ArrayList<>();
//            String rawContenTitles = myNoteSharedPref.getString(NOTE_TITLE, "");
//            String[] titlesSh = rawContenTitles.split(";");
//            for (String title : titlesSh) {
//
//                titlesShList.add(title);
//
//            }
//            String rawContenNotes = myNoteSharedPref.getString(NOTE_NOTES, "");
//            String[] notesSh = rawContenNotes.split(";");
//            for (String note : notesSh) {
//
//                notesShList.add(note);
//
//            }
//            String rawContenDead = myNoteSharedPref.getString(NOTE_DEAD, "");
//            String[] deadSh = rawContenDead.split(";");
//            for (String dead : deadSh) {
//
//                deadShList.add(dead);
//
//            }
//
//
//            int index = (titlesShList.size() - 1);
//            adapter.addItem(new ItemData(titlesShList.get(index), notesShList.get(index),
//                    deadShList.get(index)));
//            // adapter.notifyDataSetChanged();
//
//        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
//        if (!titles.isEmpty() || !notes.isEmpty() || !deadlines.isEmpty()) {
//            myNoteSharedPref = getSharedPreferences("MyNote", MODE_PRIVATE);
//            SharedPreferences.Editor myEditor = myNoteSharedPref.edit();
//            myEditor.putString(NOTE_TITLE, String.valueOf(titles));
//            myEditor.putString(NOTE_TITLE, ";");
//            myEditor.putString(NOTE_NOTES, String.valueOf(notes));
//            myEditor.putString(NOTE_NOTES, ";");
//            myEditor.putString(NOTE_DEAD, String.valueOf(deadlines));
//            myEditor.putString(NOTE_DEAD, String.valueOf(";"));
//            myEditor.apply();
//            Toast.makeText(NotesActivity.this, "данные сохранены", Toast.LENGTH_LONG).show();
//            Log.d(LOG_TAG, "onSaveInstanceState ");
//        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart()");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d(LOG_TAG, "onPostCreate");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(LOG_TAG, "onPostResume()");
    }

    private void createMethodName() {

        final StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];

        String methodName = stackTraceElement.getMethodName();
        int count;
        if (TextUtils.isEmpty(text)) {
            count = 1;

        } else {
            count = text.toString().split("\n").length + 1; // кол-ва строк в тексте
        }
        text.append(count);
        text.append(")");
        text.append(" ");
        text.append(methodName);
        text.append("\n");
        Log.d(LOG_TAG, methodName);
        textView.setText(text);

    }

}








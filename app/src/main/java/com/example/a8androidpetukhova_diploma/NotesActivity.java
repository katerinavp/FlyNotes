package com.example.a8androidpetukhova_diploma;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;


public class NotesActivity extends AppCompatActivity {

    private TextView textView = null;
    private StringBuilder text = new StringBuilder();

    private static ItemsDataAdapter adapter;
    ListView list;
    static List<String> titles = new ArrayList<>();
    static List<String> notes = new ArrayList<>();
    static List<String> deadlines = new ArrayList<>();
    final String LOG_TAG = "myLogs";
    private static String NOTE_TEXT = "note_text";
    private static String NOTE_TITLE = "note_title";
    private static String NOTE_NOTES = "note_note";
    private static String NOTE_DEAD = "note_deadline";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        Log.d(LOG_TAG, "onCreate ");

        Toolbar toolbar = findViewById(R.id.toolbar_notes);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Заметки");

            if (!titles.isEmpty()|| !notes.isEmpty() || !deadlines.isEmpty()) {
                //Log.d(LOG_TAG, "savedInstanceState != null ");

                System.out.println(titles.toString());
                System.out.println(notes.toString());
                System.out.println(deadlines.toString());

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
               // Log.d(LOG_TAG, "savedInstanceState = null ");
                initNotes();
                setOnClickAddNewNotes();
                deleteNote();
            }
        }
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
                adapter.notifyDataSetChanged();
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


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");

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

}








package com.example.a8androidpetukhova_diploma;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;
;


public class NotesActivity extends AppCompatActivity {

    private static ItemsDataAdapter adapter;
    ListView list;
    static List<String> titles = new ArrayList<>();
    static List<String> notes = new ArrayList<>();
    static List<String> deadlines = new ArrayList<>();
   // private List<Map<String, String>> result = new ArrayList<>();
   // private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Toolbar toolbar = findViewById(R.id.toolbar_notes);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Заметки");

        }

        initNotes();
        setOnClickAddNewNotes();
        deleteNote();
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

//    @NonNull
//    private void createAdapter() {
//        adapter = new ItemsDataAdapter(this, null);
//        list.setAdapter(adapter);
//        SimpleAdapter simpleAdapter  = new SimpleAdapter(this, fakeMaps, R.layout.simple_list_item, // S.A. Принимает context (MainActivivty - this с помощью контекста мы получем доступ к ресурсу),
//                //список словарей - fakeMaps, ресурс ссылка  layout строки - simple_list_item с двумя TextView (два ключа),
//                // откуда ему брать view -
//                new String[]{KEY_1, KEY_2}, new int[]{R.id.oneTxtv, R.id.twoTxtv});
//    }


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

                Intent  intentFromNotesToNewNotes = new Intent(NotesActivity.this, NewNoteActivity.class);

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

    public static void generateItemData(String title, String note, String deadline ) {
        titles.add(title);
        notes.add(note);
        deadlines.add(deadline);
        System.out.println("Данные сформированы " + titles + " " + notes + " " + deadlines);
       int index = (titles.size()-1);
       // int index = 0;
        adapter.addItem(new ItemData(titles.get(index), notes.get(index),
                deadlines.get(index)));


    }


}







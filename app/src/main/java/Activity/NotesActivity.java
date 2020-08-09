package Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.a8androidpetukhova_diploma.App;
import com.example.a8androidpetukhova_diploma.ItemData;
import com.example.a8androidpetukhova_diploma.NoteRepository;
import com.example.a8androidpetukhova_diploma.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.ItemsDataAdapter;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NotesActivity extends AppCompatActivity {

    private NoteRepository noteRepository = App.getNoteRepository();
    private TextView textView = null;
    private StringBuilder text = new StringBuilder();


    private static ItemsDataAdapter adapter;

    ListView list;
    static List<String> titles = new ArrayList<>();
    static List<String> notes = new ArrayList<>();
    static List<String> deadlines = new ArrayList<>();
    final String LOG_TAG = "myLogs";

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

}








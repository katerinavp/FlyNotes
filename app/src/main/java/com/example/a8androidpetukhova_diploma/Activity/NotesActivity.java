package com.example.a8androidpetukhova_diploma.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.a8androidpetukhova_diploma.Adapter.ItemsDataAdapter;
import com.example.a8androidpetukhova_diploma.App;
import com.example.a8androidpetukhova_diploma.ItemData;
import com.example.a8androidpetukhova_diploma.R;
import com.example.a8androidpetukhova_diploma.Repository.NoteRepository;
import java.util.List;
import java.util.Objects;


public class NotesActivity extends AppCompatActivity {

    final int DIALOG_EXIT = 1;
    private static final int NEW_NOTE_ACTIVITY_REQUEST = 20;
    private static NoteRepository noteRepository = App.getNoteRepository();
    private ItemsDataAdapter adapter;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Toolbar toolbar = findViewById(R.id.toolbar_notes);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Заметки");

        if (savedInstanceState != null) {
            noteRepository.convertFromGson();
            Log.i("myTag", "saveInstanceState != null");
        } else {
            initNotes();
            setOnClickAddNewNotes();
            correctNote();
            deleteNote();

        }
    }

    public void initNotes() {
        list = findViewById(R.id.list);
        adapter = new ItemsDataAdapter(this, null);
        list.setAdapter(adapter);
    }

    public void deleteNote() {
        // При долгом тапе по элементу списка будем удалять его
        list.setOnItemLongClickListener((parent, view, position, id) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(NotesActivity.this);
            builder.setTitle(R.string.attention);
            builder.setMessage(R.string.question_delete_the_note);
            builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                    noteRepository.getNoteById(position);
                    noteRepository.deleteById(position);
                    adapter.notifyDataSetChanged();

                }
            });

            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                }
            });
            builder.show();

            return true;
        });
    }

    public void correctNote() {
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        list.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(), NewNoteActivity.class);
            int noteIndex = adapter.getItem(position).getNoteId();
            intent.putExtra("noteIndex", noteIndex);
            System.out.println("Передаем noteIndex " + noteIndex);
            startActivity(intent);

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
        findViewById(R.id.add_new_notes).setOnClickListener(v -> {
            Intent intentFromNotesToNewNotes = new Intent(NotesActivity.this, NewNoteActivity.class);

            startActivityForResult(intentFromNotesToNewNotes, NEW_NOTE_ACTIVITY_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_NOTE_ACTIVITY_REQUEST && resultCode == RESULT_OK) {
            readNotes();
        }
    }

    private void readNotes() {
        List<ItemData> notes = noteRepository.getNotes();
        adapter.setItems(notes);
        adapter.notifyDataSetChanged();
        noteRepository.makeNewId();
        adapter.setItems(notes);
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void onStart() {
        super.onStart();
        readNotes();

    }

    public AlertDialog.Builder getErrorDialog(String message, Context context) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(getString(R.string.app_name)).setMessage(message);
        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();


            }
        });
        return alertDialog;
    }


}
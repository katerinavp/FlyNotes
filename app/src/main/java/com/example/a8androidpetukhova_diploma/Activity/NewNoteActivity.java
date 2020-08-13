package com.example.a8androidpetukhova_diploma.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.a8androidpetukhova_diploma.App;
import com.example.a8androidpetukhova_diploma.ItemData;
import com.example.a8androidpetukhova_diploma.R;
import com.example.a8androidpetukhova_diploma.Repository.NoteRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.lang.String.valueOf;

//@AndroidEntryPoint
public class NewNoteActivity extends AppCompatActivity {

    private NoteRepository noteRepository = App.getNoteRepository();
    private int noteIndex;
    EditText editTxtTitle;
    EditText editTxtNote;
    private CheckBox chBxDeadline;
    private EditText editTxtCalendar;
    private String editTxtCalendarString = "";
    private String editTxtTitleString = "";
    private String editTxtNoteString = "";
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar_new_notes);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Новая заметка");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        if (!isNewNote()) {
            initNewNote();
            intent = getIntent();
            int noteIndex = intent.getIntExtra("noteIndex", 0);
            ItemData notes = noteRepository.getNoteById(noteIndex);
            editTxtTitle.setText(notes.getTitle());
            editTxtNote.setText(notes.getNote());
            editTxtCalendar.setText(notes.getDeadline());
        }
            initNewNote();
            clickChBxDeadline();
            clickBtnCalendar();

        }

    private boolean isNewNote() {
        intent = getIntent();
        int index = intent.getIntExtra("noteIndex", -1);
        return index == -1;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //загрузка меню
        getMenuInflater().inflate(R.menu.menu_new_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // обработка кнопки menuSave
        switch (item.getItemId()) {
            case R.id.menuSave:

                if (editTxtTitleString != null & editTxtNoteString != null & editTxtCalendarString != null) {
                    System.out.println("ДАННЫЕ ЗАПОЛНЕНЫ!!!");
                    saveNote();
//                editTxtTitleString = editTxtTitle.getText().toString();
//                editTxtNoteString = editTxtNote.getText().toString();
//                NotesActivity.generateItemData(editTxtTitleString, editTxtNoteString, editTxtCalendarString);


//                titles.add(editTxtTitle.toString());
//                notes.add(editTxtNote.toString());
//                deadline.add(editTxtCalendar.toString());
//                System.out.println("Данные сформированы " + titles + " " + notes + " " + deadline);
//                NotesActivity.generateItemData(titles, notes, deadline);
//                Intent intentFromNewNotesToNotes = new Intent(NewNoteActivity.this, NotesActivity.class);
//                startActivity(intentFromNewNotesToNotes);
                    return true;
                } else {
                    Toast.makeText(NewNoteActivity.this, "Заполните заметку", Toast.LENGTH_LONG).show();
                }
            case android.R.id.home:
                Intent intentFromNewNotesToNotes = new Intent(NewNoteActivity.this, NotesActivity.class);
                startActivity(intentFromNewNotesToNotes);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void initNewNote() {
        editTxtTitle = findViewById(R.id.editTxtTitle);
        editTxtNote = findViewById(R.id.editTxtNote);
        editTxtCalendar = findViewById(R.id.editTxtCalendar);
        chBxDeadline = findViewById(R.id.chBxDeadline);

    }

    private void clickBtnCalendar() {
        findViewById(R.id.btnCalendar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(chBxDeadline.isChecked())) {
                    Toast.makeText(NewNoteActivity.this, R.string.deadline_message, Toast.LENGTH_LONG).show();
                } else {
                    callDatePicker();
                }

            }
        });
    }

    public void clickChBxDeadline() {
        chBxDeadline.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chBxDeadline.isChecked()) {
                    Date currentDate = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()); //установка текущей даты
                    editTxtCalendar.setText(dateFormat.format(currentDate));
                    editTxtCalendarString = editTxtCalendar.getText().toString();
                } else if (!chBxDeadline.isChecked()) {
                    editTxtCalendar.setText("");
                }

            }
        });
    }

    private void callDatePicker() {

        Calendar calendar = Calendar.getInstance();
        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                int month = monthOfYear + 1;
                String formattedMonth = "" + month;
                String formattedDayOfMonth = "" + dayOfMonth;
                if (month < 10) {

                    formattedMonth = "0" + month;
                }
                if (dayOfMonth < 10) {

                    formattedDayOfMonth = "0" + dayOfMonth;
                }
                editTxtCalendarString = formattedDayOfMonth + "." + formattedMonth + "." + year;
                editTxtCalendar.setText(editTxtCalendarString);

            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }

    private void saveNote() {
        ItemData itemData = new ItemData(editTxtTitle.getText().toString(), editTxtNote.getText().toString(), editTxtCalendarString);
        noteRepository.saveNote(itemData);
        setResult(RESULT_OK);
        finish();
    }

}

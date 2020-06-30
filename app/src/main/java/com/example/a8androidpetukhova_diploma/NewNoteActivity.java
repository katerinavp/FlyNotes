package com.example.a8androidpetukhova_diploma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NewNoteActivity extends AppCompatActivity {

    EditText editTxtTitle;
    EditText editTxtNote;

    private CheckBox chBxDeadline;
    private EditText editTxtCalendar;
    private String editTxtCalendarString = "";
    private String editTxtTitleString = "";
    private String editTxtNoteString = "";

//    List<String> titles = new ArrayList<>();
//    List<String> notes = new ArrayList<>();
//    List<String> deadline = new ArrayList<>();

//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Toolbar toolbar = findViewById(R.id.toolbar_new_notes);
//        setSupportActionBar(toolbar);
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setTitle("Новая заметка");
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
//        }
//
//        initNewNote();
//        clickChBxDeadline();
//        clickBtnCalendar();
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) { //загрузка меню
//        getMenuInflater().inflate(R.menu.menu_new_note, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) { // обработка кнопки menuSave
//        switch (item.getItemId()) {
//            case R.id.menuSave:
//
//                if (editTxtTitleString != null & editTxtNoteString != null & editTxtCalendarString != null) {
//                    System.out.println("ДАННЫЕ ЗАПОЛНЕНЫ!!!");
//                    saveNote();
////                editTxtTitleString = editTxtTitle.getText().toString();
////                editTxtNoteString = editTxtNote.getText().toString();
////                NotesActivity.generateItemData(editTxtTitleString, editTxtNoteString, editTxtCalendarString);
//
//
////                titles.add(editTxtTitle.toString());
////                notes.add(editTxtNote.toString());
////                deadline.add(editTxtCalendar.toString());
////                System.out.println("Данные сформированы " + titles + " " + notes + " " + deadline);
////                NotesActivity.generateItemData(titles, notes, deadline);
////                Intent intentFromNewNotesToNotes = new Intent(NewNoteActivity.this, NotesActivity.class);
////                startActivity(intentFromNewNotesToNotes);
//
//                    return true;
//                } else {
//                    Toast.makeText(NewNoteActivity.this, "Заполните заметку", Toast.LENGTH_LONG).show();
//                }
//            case android.R.id.home:
//                Intent intentFromNewNotesToNotes = new Intent(NewNoteActivity.this, NotesActivity.class);
//                startActivity(intentFromNewNotesToNotes);
//
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//
//        }
//    }
//
//    private void initNewNote() {
//        editTxtTitle = findViewById(R.id.editTxtTitle);
//        editTxtNote = findViewById(R.id.editTxtNote);
//        editTxtCalendar = findViewById(R.id.editTxtCalendar);
//        chBxDeadline = findViewById(R.id.chBxDeadline);
//
//    }
//
//    private void clickBtnCalendar() {
//        findViewById(R.id.btnCalendar).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!(chBxDeadline.isChecked())) {
//                    Toast.makeText(NewNoteActivity.this, R.string.deadline_message, Toast.LENGTH_LONG).show();
//                } else {
//                    callDatePicker();
//                }
//
//            }
//        });
//    }
//
//    public void clickChBxDeadline() {
//        chBxDeadline.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (chBxDeadline.isChecked()) {
//                    Date currentDate = new Date();
//                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()); //установка текущей даты
//                    editTxtCalendar.setText(dateFormat.format(currentDate));
//                    editTxtCalendarString = editTxtCalendar.getText().toString();
//                } else if (!chBxDeadline.isChecked()) {
//                    editTxtCalendar.setText("");
//
//                }
//
//            }
//        });
//    }
//
//    private void callDatePicker() {
//
//        Calendar calendar = Calendar.getInstance();
//        int mYear = calendar.get(Calendar.YEAR);
//        int mMonth = calendar.get(Calendar.MONTH);
//        int mDay = calendar.get(Calendar.DAY_OF_MONTH);
//        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                int month = monthOfYear + 1;
//                String formattedMonth = "" + month;
//                String formattedDayOfMonth = "" + dayOfMonth;
//                if (month < 10) {
//
//                    formattedMonth = "0" + month;
//                }
//                if (dayOfMonth < 10) {
//
//                    formattedDayOfMonth = "0" + dayOfMonth;
//                }
//                editTxtCalendarString = formattedDayOfMonth + "." + formattedMonth + "." + year;
//                editTxtCalendar.setText(editTxtCalendarString);
//
//            }
//        }, mYear, mMonth, mDay);
//        datePickerDialog.show();
//
//    }
//
//    private void saveNote() {
//        Intent intentNewNotesToNotes = new Intent();
//        intentNewNotesToNotes.putExtra("title", editTxtTitle.getText().toString());
//        intentNewNotesToNotes.putExtra("note", editTxtNote.getText().toString()); //указываем путь к файлу
//        intentNewNotesToNotes.putExtra("deadline", editTxtCalendarString);
//        setResult(RESULT_OK, intentNewNotesToNotes);
//        finish();
//
//    }
//
////        String NOTE_TEXT = "note_text";
////        //if ((editTxtTitle.getText().length() = 0) && (editTxtNote.getText().length() = 0)) {
////        SharedPreferences myNoteSharedPref = getSharedPreferences("MyNote", MODE_PRIVATE);
////        SharedPreferences.Editor myEditor = myNoteSharedPref.edit();
////        String titleTxt = editTxtTitle.getText().toString();
////        String noteTxt = editTxtNote.getText().toString();
////        myEditor.putString(NOTE_TEXT, titleTxt);
////        myEditor.putString(NOTE_TEXT, "; ");
////        myEditor.putString(NOTE_TEXT, noteTxt);
////        myEditor.putString(NOTE_TEXT, editTxtCalendarString);
////        myEditor.apply();
////        Toast.makeText(NewNoteActivity.this, R.string.data_save_info, Toast.LENGTH_LONG).show();
//
////        titles.add(editTxtTitle.toString());
////        notes.add(editTxtNote.toString());
////        deadline.add(editTxtCalendar.toString());
////        System.out.println("Данные сформированы " + titles + " " + notes + " " + deadline);
////        NotesActivity.generateItemData(titles, notes, deadline);
////        Intent intentFromNewNotesToNotes = new Intent(NewNoteActivity.this, NotesActivity.class);
////       startActivity(intentFromNewNotesToNotes);
////
////    }
//
////    private void generateItemData() {
////
////        //int index = random.nextInt(images.size());
////        adapter.addItem(new ItemData(titles.get(randomIndex), notes.get(randomIndex),
////                deadline.get(randomIndex)));
////
////
////    }
//}
//
//
//
//

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

        initNewNote();
        clickChBxDeadline();
        clickBtnCalendar();
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

                if(editTxtTitleString!= null & editTxtNoteString != null & editTxtCalendarString != null) {
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
                }else{
                    Toast.makeText(NewNoteActivity.this,"Заполните заметку", Toast.LENGTH_LONG).show();
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
        Intent intentNewNotesToNotes = new Intent();
        intentNewNotesToNotes.putExtra("title", editTxtTitle.getText().toString());
        intentNewNotesToNotes.putExtra("note", editTxtNote.getText().toString()); //указываем путь к файлу
        intentNewNotesToNotes.putExtra("deadline",  editTxtCalendarString);
        setResult(RESULT_OK, intentNewNotesToNotes);
        finish();

    }

//        String NOTE_TEXT = "note_text";
//        //if ((editTxtTitle.getText().length() = 0) && (editTxtNote.getText().length() = 0)) {
//        SharedPreferences myNoteSharedPref = getSharedPreferences("MyNote", MODE_PRIVATE);
//        SharedPreferences.Editor myEditor = myNoteSharedPref.edit();
//        String titleTxt = editTxtTitle.getText().toString();
//        String noteTxt = editTxtNote.getText().toString();
//        myEditor.putString(NOTE_TEXT, titleTxt);
//        myEditor.putString(NOTE_TEXT, "; ");
//        myEditor.putString(NOTE_TEXT, noteTxt);
//        myEditor.putString(NOTE_TEXT, editTxtCalendarString);
//        myEditor.apply();
//        Toast.makeText(NewNoteActivity.this, R.string.data_save_info, Toast.LENGTH_LONG).show();

//        titles.add(editTxtTitle.toString());
//        notes.add(editTxtNote.toString());
//        deadline.add(editTxtCalendar.toString());
//        System.out.println("Данные сформированы " + titles + " " + notes + " " + deadline);
//        NotesActivity.generateItemData(titles, notes, deadline);
//        Intent intentFromNewNotesToNotes = new Intent(NewNoteActivity.this, NotesActivity.class);
//       startActivity(intentFromNewNotesToNotes);
//
//    }

//    private void generateItemData() {
//
//        //int index = random.nextInt(images.size());
//        adapter.addItem(new ItemData(titles.get(randomIndex), notes.get(randomIndex),
//                deadline.get(randomIndex)));
//
//
//    }
}

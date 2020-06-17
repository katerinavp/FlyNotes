package com.example.a8androidpetukhova_diploma;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NotesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Toolbar toolbar = findViewById(R.id.toolbar_notes);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Заметки");

        }

        //initNotes();

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

//            case android.R.id.home:
//                Intent intentNotes = new Intent(SetupActivity.this, NotesActivity.class);
//                startActivity(intentNotes);
//                return true;
            default:
                    return super.onOptionsItemSelected(item);
        }


    }




}







package com.example.a8androidpetukhova_diploma.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.a8androidpetukhova_diploma.App;
import com.example.a8androidpetukhova_diploma.Key.Keystore;
import com.example.a8androidpetukhova_diploma.R;


public class SetupActivity extends AppCompatActivity {

    private Keystore keystore = App.getKeystore();

    private static long back_pressed;
    static final String filePassword = "Password"; //  //текст для хеширования
    private static EditText editPin;
    ImageButton imageBtnEyeBlind;
    ImageButton imageBtnEyeOpen;
    private static String PASSWORD_TEXT = "password_text";
    private SharedPreferences myPasswordSharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        Toolbar toolbar = findViewById(R.id.toolbar_setup);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Настройки");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        init();
        btnClick();
    }


    public void init() {
        editPin = findViewById(R.id.editPin);
        imageBtnEyeBlind = findViewById(R.id.imageBtnEyeBlind);
        imageBtnEyeOpen = findViewById(R.id.imageBtnEyeOpen);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // обработка кнопки menuSetup
        switch (item.getItemId()) {
//            case R.id.:
//
//                return true;

            case android.R.id.home:
                if (keystore.hasPin()) {
                    Intent intentSetupToNotes = new Intent(SetupActivity.this, NotesActivity.class);
                    startActivity(intentSetupToNotes);
                    return true;

                } else {
                    super.onBackPressed();
                    finish();
                }
            default:
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis())
            super.onBackPressed();
        else
            Toast.makeText(getBaseContext(), "Нажмите еще раз чтобы выйти",
                    Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }

    public void btnClick() {

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editPin.getText().length() == 4) {
                    keystore.saveNew(editPin.getText().toString());
                    Toast.makeText(SetupActivity.this, "данные сохранены", Toast.LENGTH_LONG).show();
                    Intent intentSetupToNotes = new Intent(SetupActivity.this, NotesActivity.class);
                    startActivity(intentSetupToNotes);
                } else {
                    {
                        Toast.makeText(SetupActivity.this, R.string.Set_password, Toast.LENGTH_LONG).show();
                    }
                }
            }

        });

        imageBtnEyeBlind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPin.setInputType(InputType.TYPE_CLASS_NUMBER);
                editPin.setTransformationMethod(null);
                imageBtnEyeBlind.setVisibility(View.GONE);
                imageBtnEyeOpen.setVisibility(View.VISIBLE);


            }
        });


        imageBtnEyeOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPin.setTransformationMethod(PasswordTransformationMethod.getInstance());
                imageBtnEyeBlind.setVisibility(View.VISIBLE);
                imageBtnEyeOpen.setVisibility(View.GONE);

            }

        });


    }

}


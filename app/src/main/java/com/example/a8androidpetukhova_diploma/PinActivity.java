package com.example.a8androidpetukhova_diploma;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static com.example.a8androidpetukhova_diploma.SetupActivity.filePassword;

public class PinActivity extends AppCompatActivity {
    StringBuilder editNumberPin;
    File f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        f = new File(getFilesDir() + "/filePassword");
        System.out.println("Путь к файлу " + f);
        if (f.exists()) {
            Toolbar toolbar = findViewById(R.id.toolbar_pin);
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("Заметки");
            }
            System.out.println("Файл найден");
            checkPin();

        } else {
            System.out.println("Файл НЕ найден");
            Intent intentFromPinToSetup = new Intent(PinActivity.this, SetupActivity.class);
            startActivity(intentFromPinToSetup);
        }

        setOnClickButton();

    }


    private View.OnClickListener numberButtonListener = new View.OnClickListener() { //создаем переменную слушателя для кнопок с цифрами и точки

        @Override
        public void onClick(View v) {
            Button buttonNumber = (Button) v;
            String numberPin = buttonNumber.getText().toString();
            editNumberPin = new StringBuilder();
            editNumberPin.append(numberPin);

            System.out.println("Введен пин код" + editNumberPin.toString());

        }
    };

    private void setOnClickButton() {
        //устанавливаем слушателя для кнопок всех
        findViewById(R.id.btn0).setOnClickListener(numberButtonListener);
        findViewById(R.id.btn1).setOnClickListener(numberButtonListener);
        findViewById(R.id.btn2).setOnClickListener(numberButtonListener);
        findViewById(R.id.btn3).setOnClickListener(numberButtonListener);
        findViewById(R.id.btn4).setOnClickListener(numberButtonListener);
        findViewById(R.id.btn5).setOnClickListener(numberButtonListener);
        findViewById(R.id.btn6).setOnClickListener(numberButtonListener);
        findViewById(R.id.btn7).setOnClickListener(numberButtonListener);
        findViewById(R.id.btn8).setOnClickListener(numberButtonListener);
        findViewById(R.id.btn9).setOnClickListener(numberButtonListener);

    }

    public void checkPin() {

        try (InputStreamReader inputStreamReaderPassword = new InputStreamReader((openFileInput(filePassword)))) {
            BufferedReader readerPassword = new BufferedReader(inputStreamReaderPassword);

            String linePassword = readerPassword.readLine();

            if (linePassword.equals(editNumberPin.toString())) {
                Toast.makeText(PinActivity.this, R.string.password_is_correct, Toast.LENGTH_LONG).show();

                Intent intentFromPinToNotes = new Intent(PinActivity.this, NotesActivity.class);
                startActivity(intentFromPinToNotes);

            } else {
                Toast.makeText(PinActivity.this, getString(R.string.password_is_incorrect), Toast.LENGTH_LONG).show();
            }
        } catch (
                IOException e) {
            e.printStackTrace();

        }

    }


}





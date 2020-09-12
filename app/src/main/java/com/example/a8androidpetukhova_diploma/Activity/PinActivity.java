package com.example.a8androidpetukhova_diploma.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.a8androidpetukhova_diploma.App;
import com.example.a8androidpetukhova_diploma.Key.Keystore;
import com.example.a8androidpetukhova_diploma.R;

public class PinActivity extends AppCompatActivity {

    private Keystore keystore = App.getKeystore();
    StringBuilder numberPinBuilder = new StringBuilder();
    String numberPinString;
    View imageCircle1;
    View imageCircle2;
    View imageCircle3;
    View imageCircle4;
    View imageCircleYel1;
    View imageCircleYel2;
    View imageCircleYel3;
    View imageCircleYel4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        Toolbar toolbar = findViewById(R.id.toolbar_pin);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Заметки");
        }
        setOnClickAddPassword();
        deleteNumber();
        setOnClickButton();
    }

    public void setOnClickAddPassword() {
        if (!keystore.hasPin()) {
            Intent intentFromPinToSetup = new Intent(PinActivity.this, SetupActivity.class);
            startActivity(intentFromPinToSetup);
        }
    }

    private View.OnClickListener numberButtonListener = new View.OnClickListener() { //создаем переменную слушателя для кнопок с цифрами и точки
        @Override
        public void onClick(View v) {
            imageCircle1 = findViewById(R.id.imageCircle1);
            imageCircle2 = findViewById(R.id.imageCircle2);
            imageCircle3 = findViewById(R.id.imageCircle3);
            imageCircle4 = findViewById(R.id.imageCircle4);
            imageCircleYel1 = findViewById(R.id.imageCircleYel1);
            imageCircleYel2 = findViewById(R.id.imageCircleYel2);
            imageCircleYel3 = findViewById(R.id.imageCircleYel3);
            imageCircleYel4 = findViewById(R.id.imageCircleYel4);

            Button buttonNumber = (Button) v;
            String numberPin = buttonNumber.getText().toString();
            numberPinBuilder.append(numberPin);
            numberPinString = numberPinBuilder.toString();

            switch (numberPinBuilder.length()) {
                case (1):
                    imageCircle1.setVisibility(View.INVISIBLE);
                    imageCircleYel1.setVisibility(View.VISIBLE);
                    imageCircle2.setVisibility(View.VISIBLE);
                    imageCircleYel2.setVisibility(View.INVISIBLE);
                    imageCircle3.setVisibility(View.VISIBLE);
                    imageCircleYel3.setVisibility(View.INVISIBLE);
                    imageCircle4.setVisibility(View.VISIBLE);
                    imageCircleYel4.setVisibility(View.INVISIBLE);
                    break;
                case (2):
                    imageCircle1.setVisibility(View.INVISIBLE);
                    imageCircleYel1.setVisibility(View.VISIBLE);
                    imageCircle2.setVisibility(View.INVISIBLE);
                    imageCircleYel2.setVisibility(View.VISIBLE);
                    imageCircle3.setVisibility(View.VISIBLE);
                    imageCircleYel3.setVisibility(View.INVISIBLE);
                    imageCircle4.setVisibility(View.VISIBLE);
                    imageCircleYel4.setVisibility(View.INVISIBLE);
                    break;
                case (3):
                    imageCircle1.setVisibility(View.INVISIBLE);
                    imageCircleYel1.setVisibility(View.VISIBLE);
                    imageCircle2.setVisibility(View.INVISIBLE);
                    imageCircleYel2.setVisibility(View.VISIBLE);
                    imageCircle3.setVisibility(View.INVISIBLE);
                    imageCircleYel3.setVisibility(View.VISIBLE);
                    imageCircle4.setVisibility(View.VISIBLE);
                    imageCircleYel4.setVisibility(View.INVISIBLE);
                    break;
                case (4):
                    imageCircle1.setVisibility(View.INVISIBLE);
                    imageCircleYel1.setVisibility(View.VISIBLE);
                    imageCircle2.setVisibility(View.INVISIBLE);
                    imageCircleYel2.setVisibility(View.VISIBLE);
                    imageCircle3.setVisibility(View.INVISIBLE);
                    imageCircleYel3.setVisibility(View.VISIBLE);
                    imageCircle4.setVisibility(View.INVISIBLE);
                    imageCircleYel4.setVisibility(View.VISIBLE);
                    break;
            }
            //Toast.makeText(PinActivity.this, numberPinString, Toast.LENGTH_LONG).show();
            if (numberPinString.length() != 4) {
                setOnClickButton();
                //Toast.makeText(PinActivity.this, numberPinString, Toast.LENGTH_LONG).show();
            } else {
                // Toast.makeText(PinActivity.this, numberPinString, Toast.LENGTH_LONG).show();
                checkPin(numberPinString);
            }
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

    public void deleteNumber() {
        findViewById(R.id.imageBtnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberPinBuilder.length() == 0) {
                    Toast.makeText(PinActivity.this, "Введите пароль", Toast.LENGTH_LONG).show();
                    setOnClickButton();
                } else {
                    numberPinBuilder.setLength(numberPinBuilder.length() - 1);
                    switch (numberPinBuilder.length()) {
                        case (0):
                            imageCircle1.setVisibility(View.VISIBLE);
                            imageCircleYel1.setVisibility(View.INVISIBLE);
                            imageCircle2.setVisibility(View.VISIBLE);
                            imageCircleYel2.setVisibility(View.INVISIBLE);
                            imageCircle3.setVisibility(View.VISIBLE);
                            imageCircleYel3.setVisibility(View.INVISIBLE);
                            imageCircle4.setVisibility(View.VISIBLE);
                            imageCircleYel4.setVisibility(View.INVISIBLE);
                            break;
                        case (1):
                            imageCircle1.setVisibility(View.INVISIBLE);
                            imageCircleYel1.setVisibility(View.VISIBLE);
                            imageCircle2.setVisibility(View.VISIBLE);
                            imageCircleYel2.setVisibility(View.INVISIBLE);
                            imageCircle3.setVisibility(View.VISIBLE);
                            imageCircleYel3.setVisibility(View.INVISIBLE);
                            imageCircle4.setVisibility(View.VISIBLE);
                            imageCircleYel4.setVisibility(View.INVISIBLE);
                            break;
                        case (2):
                            imageCircle1.setVisibility(View.INVISIBLE);
                            imageCircleYel1.setVisibility(View.VISIBLE);
                            imageCircle2.setVisibility(View.INVISIBLE);
                            imageCircleYel2.setVisibility(View.VISIBLE);
                            imageCircle3.setVisibility(View.VISIBLE);
                            imageCircleYel3.setVisibility(View.INVISIBLE);
                            imageCircle4.setVisibility(View.VISIBLE);
                            imageCircleYel4.setVisibility(View.INVISIBLE);
                            break;
                        case (3):
                            imageCircle1.setVisibility(View.INVISIBLE);
                            imageCircleYel1.setVisibility(View.VISIBLE);
                            imageCircle2.setVisibility(View.INVISIBLE);
                            imageCircleYel2.setVisibility(View.VISIBLE);
                            imageCircle3.setVisibility(View.INVISIBLE);
                            imageCircleYel3.setVisibility(View.VISIBLE);
                            imageCircle4.setVisibility(View.VISIBLE);
                            imageCircleYel4.setVisibility(View.INVISIBLE);
                            break;
                        case (4):
                            imageCircle1.setVisibility(View.INVISIBLE);
                            imageCircleYel1.setVisibility(View.VISIBLE);
                            imageCircle2.setVisibility(View.INVISIBLE);
                            imageCircleYel2.setVisibility(View.VISIBLE);
                            imageCircle3.setVisibility(View.INVISIBLE);
                            imageCircleYel3.setVisibility(View.VISIBLE);
                            imageCircle4.setVisibility(View.INVISIBLE);
                            imageCircleYel4.setVisibility(View.VISIBLE);
                            break;
                    }
                    //Toast.makeText(PinActivity.this, numberPinBuilder.toString(), Toast.LENGTH_LONG).show();
                    setOnClickButton();
                }
            }
        });
    }

    private void checkPin(String numberPinString) {
        if (!keystore.checkPin(numberPinString)) {
            Toast.makeText(PinActivity.this, getString(R.string.password_is_incorrect), Toast.LENGTH_LONG).show();
            numberPinBuilder.setLength(0); // сброс StringBuilder
            imageCircle1.setVisibility(View.VISIBLE);
            imageCircleYel1.setVisibility(View.INVISIBLE);
            imageCircle2.setVisibility(View.VISIBLE);
            imageCircleYel2.setVisibility(View.INVISIBLE);
            imageCircle3.setVisibility(View.VISIBLE);
            imageCircleYel3.setVisibility(View.INVISIBLE);
            imageCircle4.setVisibility(View.VISIBLE);
            imageCircleYel4.setVisibility(View.INVISIBLE);
            setOnClickButton();
            //Toast.makeText(PinActivity.this, numberPinString, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(PinActivity.this, R.string.password_is_correct, Toast.LENGTH_LONG).show();
            Intent intentPinToNotes = new Intent(PinActivity.this, NotesActivity.class);
            startActivity(intentPinToNotes);
        }
    }
}
package com.petukhova.flynotes.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.petukhova.flynotes.App;
import com.petukhova.flynotes.Key.Keystore;
import com.petukhova.flynotes.R;
import java.util.ArrayList;
import java.util.List;

public class PinActivity extends AppCompatActivity {

    private final Keystore keystore = App.getKeystore();
    private final StringBuilder numberPinBuilder = new StringBuilder();
    private final List<ImageView> circleButtons = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkHasPin();

        setContentView(R.layout.activity_pin);

        init();
        deleteNumber();
        setOnClickButton();
    }

    public void checkHasPin() {
        if (!keystore.hasPin()) {
            Intent intentFromPinToSetup = new Intent(PinActivity.this, SetupActivity.class);
            startActivity(intentFromPinToSetup);
            finish(); // Завершаем текущую активити пользователь не мог больше сюда попасть по кнопке back
        }
    }

    private void init() {
        Toolbar toolbar = findViewById(R.id.toolbar_pin);
        setSupportActionBar(toolbar);

        ImageView imageCircle1 = findViewById(R.id.imageCircle1);
        ImageView imageCircle2 = findViewById(R.id.imageCircle2);
        ImageView imageCircle3 = findViewById(R.id.imageCircle3);
        ImageView imageCircle4 = findViewById(R.id.imageCircle4);

        circleButtons.add(imageCircle1);
        circleButtons.add(imageCircle2);
        circleButtons.add(imageCircle3);
        circleButtons.add(imageCircle4);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.Notes);
        }
    }


    private final View.OnClickListener numberButtonListener = new View.OnClickListener() { //создаем переменную слушателя для кнопок с цифрами и точки
        @Override
        public void onClick(View v) {
            Button buttonNumber = (Button) v;
            String numberPin = buttonNumber.getText().toString();
            numberPinBuilder.append(numberPin);
            String numberPinString = numberPinBuilder.toString();

            refreshCircleIcons();

            if (numberPinString.length() > 3) {
                checkPin(numberPinString);
            }
        }
    };

    // обновить состояние кнопок
    private void refreshCircleIcons() {
        for (int i = 0; i <= circleButtons.size() - 1; i++) {

            // Чекам нажата ли кнопка. Определяем из размера numberPinBuilder
            boolean isChecked = numberPinBuilder.length() - 1 >= i;
            ImageView imageView = circleButtons.get(i);

            int icon;
            if (isChecked) {
                icon = R.drawable.circle_yellow;
            } else {
                icon = R.drawable.circle;
            }

            // Переключаем у картинки фон
            imageView.setImageDrawable(ContextCompat.getDrawable(this, icon));
        }
    }

    private void setOnClickButton() {
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
                    Toast.makeText(PinActivity.this, R.string.enter_your_password, Toast.LENGTH_LONG).show();
                    setOnClickButton();
                } else {
                    numberPinBuilder.setLength(numberPinBuilder.length() - 1);
                    refreshCircleIcons();
                }
            }
        });
    }

    private void checkPin(String numberPinString) {
        if (!keystore.checkPin(numberPinString)) {
            Toast.makeText(PinActivity.this, getString(R.string.password_is_incorrect), Toast.LENGTH_LONG).show();
            numberPinBuilder.setLength(0); // сброс StringBuilder
            refreshCircleIcons();
        } else {
            Toast.makeText(PinActivity.this, R.string.password_is_correct, Toast.LENGTH_LONG).show();
            Intent intentPinToNotes = new Intent(PinActivity.this, NotesActivity.class);
            startActivity(intentPinToNotes);
            finish();
        }
    }
}
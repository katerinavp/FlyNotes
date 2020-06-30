package com.example.a8androidpetukhova_diploma;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.File;
import java.util.ArrayList;

public class PinActivity extends AppCompatActivity {

    String fileP;
    //    ArrayList<String> ArrayNumberPin = new ArrayList<>(4);
    ArrayList<String> ArrayNumberPin = null;
    ArrayList<String> ArraySavePin = null;
//    StringBuilder numberPinBuilder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        Toolbar toolbar = findViewById(R.id.toolbar_pin);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Заметки");
        }
        File f = new File(getFilesDir(), "Password");

        if (!f.exists()) {
            System.out.println("Файл НЕ найден");
            setOnClickAddPassword();
            Toast.makeText(PinActivity.this, f.toString(), Toast.LENGTH_LONG).show();
        } else {
            System.out.println("Файл найден");
//            setOnClickAddNewNotes();
            Toast.makeText(PinActivity.this, f.toString(), Toast.LENGTH_LONG).show();
//            setOnClickButton();

        }

        //setOnClickButton();

    }

    private void setOnClickAddPassword() {

        Intent intentFromPinToSetup = new Intent(PinActivity.this, SetupActivity.class);

        startActivity(intentFromPinToSetup);

    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (data == null) {
//            return;
//        }
////        fileP = data.getStringExtra("fileP");
////        // Toast.makeText(PinActivity.this, fileP, Toast.LENGTH_LONG).show();
////        setOnClickButton();
////        savePinForCompare(fileP);
////        checkPin(fileP);
//    }

    private View.OnClickListener numberButtonListener = new View.OnClickListener() { //создаем переменную слушателя для кнопок с цифрами и точки

        @Override
        public void onClick(View v) {
            Button buttonNumber = (Button) v;
            String numberPin = buttonNumber.getText().toString();
            buildPin(numberPin);
//
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

    private void buildPin(String numberPin) {
        if (ArrayNumberPin == null) {
            ArrayNumberPin = new ArrayList<>();
            ArrayNumberPin.add(numberPin);
            Toast.makeText(PinActivity.this, ArrayNumberPin.toString(), Toast.LENGTH_LONG).show();

        } else if (ArrayNumberPin.size() > 0 && ArrayNumberPin.size() < 4) {
            ArrayNumberPin.add(numberPin);
            Toast.makeText(PinActivity.this, ArrayNumberPin.toString(), Toast.LENGTH_LONG).show();
        } else if (ArrayNumberPin.size() == 4) {
            StringBuilder numberPinBuilder = new StringBuilder();
            for (String list : ArrayNumberPin) {
                numberPinBuilder.append(list);

            }
            String numberPinBuilderString = numberPinBuilder.toString();
            savePinForCompare(numberPinBuilderString);
//            System.out.println(numberPinBuilder.toString());
//            String numberPinBuilderString = numberPinBuilder.toString();
//            checkPin(numberPinBuilderString);

//        }else{
//            Toast.makeText(PinActivity.this, "Проверка!!!", Toast.LENGTH_LONG).show();
//            String ArrayNumberPinString = ArrayNumberPin.toString();
//            Toast.makeText(PinActivity.this, ArrayNumberPinString, Toast.LENGTH_LONG).show();
//            char[] chs = ArrayNumberPin.toString().toCharArray();
//            for (char ch : chs) {
//                if (Character.isLetter(ch)) {
//                    ArrayNumberPinString = ArrayNumberPin.toString();
//                    Toast.makeText(PinActivity.this, ArrayNumberPinString, Toast.LENGTH_LONG).show();
//                }
//            }
//            checkPin(ArrayNumberPinString);
//        } else {
//            v.setClickable(false);
//
//        if (ArrayNumberPin == null) {
////            ArrayNumberPin = new ArrayList<>();
//            ArrayNumberPin.add(numberPin);
//            Toast.makeText(PinActivity.this, ArrayNumberPin.toString(), Toast.LENGTH_LONG).show();
        }


//        StringBuilder numberPinBuilder = new StringBuilder();
//                for (String pin : ArrayNumberPin) {
//                    numberPinBuilder.append(pin);
//            Toast.makeText(PinActivity.this, pin, Toast.LENGTH_LONG).show();

//        } else if(!ArrayNumberPin.isEmpty()){
//            ArrayNumberPin.add(numberPin);
//
//        }else {
//            if(ArrayNumberPin.c == 4){
//
//            }
    }
//            (ArrayNumberPin.size() > 0 && ArrayNumberPin.size() < 4) {
//            ArrayNumberPin.add(numberPin);
//            Toast.makeText(PinActivity.this, ArrayNumberPin.toString(), Toast.LENGTH_LONG).show();
//
//        } else if (ArrayNumberPin.size() == 4) {
//                ArrayNumberPin.add(numberPin);
//                Toast.makeText(PinActivity.this, ArrayNumberPin.toString(), Toast.LENGTH_LONG).show();
//                StringBuilder numberPinBuilder = new StringBuilder();
//                for (String list : ArrayNumberPin) {
//                    numberPinBuilder.append(list);
//
//                }
//                String numberPinBuilderString = numberPinBuilder.toString();
//                System.out.println(numberPinBuilderString);
//                Toast.makeText(PinActivity.this, numberPinBuilderString, Toast.LENGTH_LONG).show();
//                savePinForCompare(numberPinBuilderString);
////                checkPin(numberPinBuilderString);
//            }


    private void savePinForCompare(String pinCode) {
        if (ArraySavePin == null) {
            ArraySavePin = new ArrayList<>();
            ArraySavePin.add(pinCode);

        } else if (ArraySavePin.size() == 1) {
            ArraySavePin.add(pinCode);

            Toast.makeText(PinActivity.this, ArraySavePin.toString(), Toast.LENGTH_LONG).show();
            Toast.makeText(PinActivity.this, ("Первый элемент " + (ArraySavePin.get(0))), Toast.LENGTH_LONG).show();
            Toast.makeText(PinActivity.this, ("Второй элемент " + (ArraySavePin.get(1))), Toast.LENGTH_LONG).show();
            if (ArraySavePin.get(0).equals(ArraySavePin.get(1))) {
                Toast.makeText(PinActivity.this, R.string.password_is_correct, Toast.LENGTH_LONG).show();

                Intent intentFromPinToNotes = new Intent(PinActivity.this, NotesActivity.class);
                startActivity(intentFromPinToNotes);

            } else {
                ArraySavePin.remove(1);
                Toast.makeText(PinActivity.this, getString(R.string.password_is_incorrect), Toast.LENGTH_LONG).show();
                setOnClickButton();
            }

        }
//
//
//        return false;
//    }


//    public void checkPin(String numberPinBuilderString) {

//        try (InputStreamReader inputStreamReaderPassword = new InputStreamReader((openFileInput(filePassword)))) {
//            BufferedReader readerPassword = new BufferedReader(inputStreamReaderPassword);
//
//            String linePassword = readerPassword.readLine();
//
//            if (linePassword.equals(numberPinBuilderString)) {
//                Toast.makeText(PinActivity.this, R.string.password_is_correct, Toast.LENGTH_LONG).show();
//
//                Intent intentFromPinToNotes = new Intent(PinActivity.this, NotesActivity.class);
//                startActivity(intentFromPinToNotes);
//
//            } else {
//                Toast.makeText(PinActivity.this, getString(R.string.password_is_incorrect), Toast.LENGTH_LONG).show();
//            }
//        } catch (
//                IOException e) {
//            e.printStackTrace();
//
//        }
//        Toast.makeText(PinActivity.this, "Проверка ПИН КОДА!!!", Toast.LENGTH_LONG).show();
////        if (fileP.equals(numberPinBuilderString)) {
////            Toast.makeText(PinActivity.this, R.string.password_is_correct, Toast.LENGTH_LONG).show();
////
////            Intent intentFromPinToNotes = new Intent(PinActivity.this, NotesActivity.class);
////            startActivity(intentFromPinToNotes);
////
////        } else {
////            Toast.makeText(PinActivity.this, getString(R.string.password_is_incorrect), Toast.LENGTH_LONG).show();
////        }

//    }
    }
}








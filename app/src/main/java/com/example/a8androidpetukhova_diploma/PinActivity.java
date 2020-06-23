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
    ArrayList<String> ArrayNumberPin = null;


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
        } else {
            System.out.println("Файл найден");
//            setOnClickAddNewNotes();

            setOnClickButton();

        }

        //setOnClickButton();

    }

    private void setOnClickAddPassword() {

        Intent intentFromPinToSetup = new Intent(PinActivity.this, SetupActivity.class);

        startActivityForResult(intentFromPinToSetup, 20);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        fileP = data.getStringExtra("fileP");
        setOnClickButton();
        // checkPin(fileP);
    }

    private View.OnClickListener numberButtonListener = new View.OnClickListener() { //создаем переменную слушателя для кнопок с цифрами и точки

        @Override
        public void onClick(View v) {
            Button buttonNumber = (Button) v;
            String numberPin = buttonNumber.getText().toString();
            buildPin(numberPin);

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

    public void buildPin(String numberPin) {
        if (ArrayNumberPin == null) {
            ArrayNumberPin = new ArrayList<>();
            ArrayNumberPin.add(numberPin);
            Toast.makeText(PinActivity.this, ArrayNumberPin.toString(), Toast.LENGTH_LONG).show();
        } else if (ArrayNumberPin.size() > 0 && ArrayNumberPin.size() < 4) {
            ArrayNumberPin.add(numberPin);
            Toast.makeText(PinActivity.this, ArrayNumberPin.toString(), Toast.LENGTH_LONG).show();
//        } else if(){
//            checkPin();
//
//        }
        }
    }


    public void checkPin() {

//        try (InputStreamReader inputStreamReaderPassword = new InputStreamReader((openFileInput(filePassword)))) {
//            BufferedReader readerPassword = new BufferedReader(inputStreamReaderPassword);
//
//            String linePassword = readerPassword.readLine();
//
//            if (linePassword.equals(editNumberPin.toString())) {
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

        if (fileP.equals(ArrayNumberPin.toString())) {
            Toast.makeText(PinActivity.this, R.string.password_is_correct, Toast.LENGTH_LONG).show();

            Intent intentFromPinToNotes = new Intent(PinActivity.this, NotesActivity.class);
            startActivity(intentFromPinToNotes);

        } else {
            Toast.makeText(PinActivity.this, getString(R.string.password_is_incorrect), Toast.LENGTH_LONG).show();
        }

    }
}








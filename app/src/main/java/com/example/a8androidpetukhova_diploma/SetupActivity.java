package com.example.a8androidpetukhova_diploma;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.io.FileOutputStream;
import java.io.IOException;


public class SetupActivity extends AppCompatActivity {

    static final String filePassword = "Password"; //  //текст для хеширования
    private static EditText editPin;

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
        savePassword();
    }


    public void init() {
        editPin = findViewById(R.id.editPin);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // обработка кнопки menuSetup
        switch (item.getItemId()) {
//            case R.id.menuSetup:
//                Intent intentSetup = new Intent(NotesActivity.this, SetupActivity.class);
//                startActivity(intentSetup);
//                return true;

            case android.R.id.home:
                Intent intentNotes = new Intent(SetupActivity.this, NotesActivity.class);
                startActivity(intentNotes);
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);

    }

    public void savePassword() {

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editPin.getText().length() == 4) {
//
//                    MessageDigest md = null;
//                    try {
//                        md = MessageDigest.getInstance("MD5");
//                    } catch (NoSuchAlgorithmException e) {
//                        e.printStackTrace();
//                    }
//                    md.update(filePassword.getBytes());
//
//                    byte byteData[] = md.digest();
//
//                    //конвертируем байт в шестнадцатеричный формат первым способом
//                    StringBuffer sb = new StringBuffer();
//                    for (byte aByteData : byteData) {
//                        sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
//                    }
//                    System.out.println("Текст в шестнадцатеричном виде : " + sb.toString());

                    try (
                            FileOutputStream fileOutputStreamLogin = openFileOutput(filePassword, MODE_PRIVATE)) {
                        fileOutputStreamLogin.write(editPin.getText().toString().getBytes());
                    } catch (
                            IOException e) {
                        e.printStackTrace();
                    }
                    try (
                            FileOutputStream fileOutputStreamPassword = openFileOutput(filePassword, MODE_PRIVATE)) {
                        fileOutputStreamPassword.write(editPin.getText().toString().getBytes());

                    } catch (
                            IOException e) {
                        e.printStackTrace();
                    }

                    Toast.makeText(SetupActivity.this, R.string.Save_Password, Toast.LENGTH_LONG).
                            show();

                    Intent intentFromSetupToPin = new Intent(SetupActivity.this, PinActivity.class);
                    startActivity(intentFromSetupToPin);

                } else {
                    {
                        Toast.makeText(SetupActivity.this, R.string.Set_password, Toast.LENGTH_LONG).show();
                    }
                }
            }

        });
    }


}

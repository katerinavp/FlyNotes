package com.example.a8androidpetukhova_diploma;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        Toolbar toolbar = findViewById(R.id.toolbar_pin);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Заметки");


            Drawable background = View.getBackground();
            if (background instanceof ShapeDrawable) {
                ((ShapeDrawable)background).getPaint().setColor(getResources().getColor(R.color.colorCircle));
            } else if (background instanceof GradientDrawable) {
                ((GradientDrawable)background).setColor(getResources().getColor(R.color.colorToSet));
            } else if (background instanceof ColorDrawable) {
                ((ColorDrawable)background).setColor(getResources().getColor(R.color.colorToSet));
            }
        }


    }
}

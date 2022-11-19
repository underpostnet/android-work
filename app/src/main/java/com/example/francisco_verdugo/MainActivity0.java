package com.example.francisco_verdugo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity0 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);
        Log.i("INFO", "onCreate MainActivity0");

        Button buttonMainActivity = (Button) findViewById(R.id.menu_btn_activity_main);
        Button buttonMainActivity0 = (Button) findViewById(R.id.menu_btn_activity_main_0);

        buttonMainActivity.setOnClickListener(v -> {
            // Do something in response to button click}
            Log.i("INFO", "buttonMainActivity.setOnClickListener");
            Intent intent = new Intent(MainActivity0.this, MainActivity.class);
            startActivity(intent);
        });

        buttonMainActivity0.setOnClickListener(v -> {
            // Do something in response to button click}
            Log.i("INFO", "buttonMainActivity0.setOnClickListener");
        });
    }
}
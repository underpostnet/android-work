package com.example.francisco_verdugo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("INFO", "onCreate MainActivity");
        // ComponentMenu menuInstance = new ComponentMenu();

        Button buttonMainActivity = (Button) findViewById(R.id.menu_btn_activity_main);
        Button buttonMainActivity0 = (Button) findViewById(R.id.menu_btn_activity_main_0);

        buttonMainActivity.setOnClickListener(v -> {
            // Do something in response to button click}
            Log.i("INFO", "buttonMainActivity.setOnClickListener");
        });

        buttonMainActivity0.setOnClickListener(v -> {
            // Do something in response to button click}
            Log.i("INFO", "buttonMainActivity0.setOnClickListener");
            Intent intent = new Intent(MainActivity.this, MainActivity0.class);
            startActivity(intent);
        });

        // menuInstance.initBtnMenuEvent(buttonMainActivity, buttonMainActivity0);

    }
}
package com.example.francisco_verdugo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

               // Log.e(String, String) error
               // Log.w(String, String) advertise
               // Log.i(String, String) information
               // Log.d(String, String) deputation
               // Log.v(String, String) registry detailed

        Button buttonMainActivity = (Button) findViewById(R.id.menu_btn_activity_main);
        buttonMainActivity.setOnClickListener(v -> {
            // Do something in response to button click}
            Log.i("INFO", "buttonMainActivity.setOnClickListener");
        });

        Button buttonMainActivity0 = (Button) findViewById(R.id.menu_btn_activity_main_0);
        buttonMainActivity0.setOnClickListener(v -> {
            // Do something in response to button click}
            Log.i("INFO", "buttonMainActivity0.setOnClickListener");
        });

    }
}
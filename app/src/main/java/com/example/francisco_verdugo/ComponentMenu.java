package com.example.francisco_verdugo;

import android.util.Log;
import android.widget.Button;

public class ComponentMenu {



    public void initBtnMenuEvent(Button buttonMainActivity,  Button buttonMainActivity0){

        // Log.e(String, String) error
        // Log.w(String, String) advertise
        // Log.i(String, String) information
        // Log.d(String, String) deputation
        // Log.v(String, String) registry detailed

        buttonMainActivity.setOnClickListener(v -> {
            // Do something in response to button click}
            Log.i("INFO", "buttonMainActivity.setOnClickListener");
        });

        buttonMainActivity0.setOnClickListener(v -> {
            // Do something in response to button click}
            Log.i("INFO", "buttonMainActivity0.setOnClickListener");
        });

    }
}
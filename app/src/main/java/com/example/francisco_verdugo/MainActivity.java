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
        ComponentMenu menuInstance = new ComponentMenu();

        Button buttonMainActivity = (Button) findViewById(R.id.menu_btn_activity_main);
        Button buttonMainActivity0 = (Button) findViewById(R.id.menu_btn_activity_main_0);
        
        menuInstance.initBtnMenuEvent(buttonMainActivity, buttonMainActivity0);

    }
}
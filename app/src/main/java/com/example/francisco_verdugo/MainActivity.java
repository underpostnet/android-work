package com.example.francisco_verdugo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected ListView listview;
    private final ArrayList<String> names = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("INFO", "onCreate MainActivity");


        Button menu_adm_capture = findViewById(R.id.menu_adm_capture);
        Button menu_adm_list = findViewById(R.id.menu_adm_list);
        Button menu_adm_gfx = findViewById(R.id.menu_adm_gfx);

        menu_adm_capture.setOnClickListener(v -> {
            // Do something in response to button click}
            Log.i("INFO", "menu_adm_capture.setOnClickListener");
            Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
            startActivity(intent);
        });
        menu_adm_list.setOnClickListener(v -> {
            // Do something in response to button click}
            Log.i("INFO", "menu_adm_list.setOnClickListener");
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            startActivity(intent);
        });
        menu_adm_gfx.setOnClickListener(v -> {
            // Do something in response to button click}
            Log.i("INFO", "menu_adm_gfx.setOnClickListener");
            Intent intent = new Intent(MainActivity.this, GfxActivity.class);
            startActivity(intent);
        });

        // this.renderList();
        // this.renderListAdapter();
        // ComponentMenu menuInstance = new ComponentMenu();

        // Button buttonMainActivity = findViewById(R.id.menu_btn_activity_main);
        // Button buttonMainActivity0 = findViewById(R.id.menu_btn_activity_main_0);

        // buttonMainActivity.setOnClickListener(v -> {
        //     // Do something in response to button click}
        //     Log.i("INFO", "buttonMainActivity.setOnClickListener");
        // });

        // buttonMainActivity0.setOnClickListener(v -> {
        //     // Do something in response to button click}
        //     Log.i("INFO", "buttonMainActivity0.setOnClickListener");
        //     Intent intent = new Intent(MainActivity.this, MainActivity0.class);
        //     startActivity(intent);
        // });

        // menuInstance.initBtnMenuEvent(buttonMainActivity, buttonMainActivity0);

    }

    // private void renderList() {
    //     this.listview = findViewById(R.id.formula1_list_view);
    //     this.names.add("Mercedes");
    //     this.names.add("Alpine");
    //     this.names.add("Haas");
    //     ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.formula1_list, R.id.formula1_list_view_text,
    //             names);
    //     this.listview.setAdapter(adapter);
    // }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i("INFO", "onCreateOptionsMenu");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.add_item_formula1_list:
                Log.i("INFO", "add_item_formula1_list");
                Intent intent = new Intent(MainActivity.this, MainActivity0.class);
                startActivity(intent);
                return true;
            case 0:
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
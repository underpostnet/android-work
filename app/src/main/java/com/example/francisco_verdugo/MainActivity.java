package com.example.francisco_verdugo;

import androidx.appcompat.app.AppCompatActivity;

// import android.content.Intent;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
// import android.view.Menu;
// import android.view.MenuInflater;
// import android.view.MenuItem;
// import android.widget.Button;
import android.widget.Button;
import android.widget.ListView;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;




import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDatePicker, btnTimePicker;
    EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;

    // protected ListView listview;
    // private final ArrayList<String> names = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("INFO", "onCreate MainActivity");

        btnDatePicker=(Button)findViewById(R.id.btn_date);
        btnTimePicker=(Button)findViewById(R.id.btn_time);
        txtDate=(EditText)findViewById(R.id.in_date);
        txtTime=(EditText)findViewById(R.id.in_time);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);


        // Button menu_adm_capture = findViewById(R.id.menu_adm_capture);
        // Button menu_adm_list = findViewById(R.id.menu_adm_list);
        // Button menu_adm_gfx = findViewById(R.id.menu_adm_gfx);

        // menu_adm_capture.setOnClickListener(v -> {
        //     // Do something in response to button click}
        //     Log.i("INFO", "menu_adm_capture.setOnClickListener");
        //     Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
        //     startActivity(intent);
        // });
        // menu_adm_list.setOnClickListener(v -> {
        //     // Do something in response to button click}
        //     Log.i("INFO", "menu_adm_list.setOnClickListener");
        //     Intent intent = new Intent(MainActivity.this, ListActivity.class);
        //     startActivity(intent);
        // });
        // menu_adm_gfx.setOnClickListener(v -> {
        //     // Do something in response to button click}
        //     Log.i("INFO", "menu_adm_gfx.setOnClickListener");
        //     Intent intent = new Intent(MainActivity.this, GfxActivity.class);
        //     startActivity(intent);
        // });

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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }
    public void onClickAddDetails(View view) {
        ContentValues values = new ContentValues();
        values.put(DataFlairProvider.name, ((EditText)        findViewById(R.id.txtName)).getText().toString());
        getContentResolver().insert(DataFlairProvider.CONTENT_URI, values);
        Toast.makeText(getBaseContext(), "New Record Inserted", Toast.LENGTH_LONG).show();
    }

    @SuppressLint("Range")
    public void onClickShowDetails(View view) {
        TextView resultView= (TextView) findViewById(R.id.res);
        Cursor cursor = getContentResolver().query(Uri.parse("content://com.dataflair.contentprovider.UserProvider/users"), null, null, null, null);
        if(cursor.moveToFirst()) {
            StringBuilder strBuild=new StringBuilder();
            while (!cursor.isAfterLast()) {
                strBuild.append("\n"+cursor.getString(cursor.getColumnIndex("id"))+ "-"+ cursor.getString(cursor.getColumnIndex("name")));
                cursor.moveToNext();
            }
            resultView.setText(strBuild);
        }
        else {
            resultView.setText("No Records Found");
        }
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


    // @Override
    // public boolean onCreateOptionsMenu(Menu menu) {
    //     Log.i("INFO", "onCreateOptionsMenu");
    //     MenuInflater inflater = getMenuInflater();
    //     inflater.inflate(R.menu.menu, menu);
    //     return true;
    // }

    // @SuppressLint("NonConstantResourceId")
    // @Override
    // public boolean onOptionsItemSelected(MenuItem item) {
    //     // Handle item selection
    //     switch (item.getItemId()) {
    //         case R.id.add_item_formula1_list:
    //             Log.i("INFO", "add_item_formula1_list");
    //             Intent intent = new Intent(MainActivity.this, MainActivity0.class);
    //             startActivity(intent);
    //             return true;
    //         case 0:
    //             return false;
    //         default:
    //             return super.onOptionsItemSelected(item);
    //     }
    // }

    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            Log.i("INFO", "onDateSet "+dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                                                Log.i("INFO", "onTimeSet "+hourOfDay + ":" + minute);

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }


}
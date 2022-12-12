package com.example.francisco_verdugo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LogInActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    TextView password;
    TextView rut;
    public static final String mypreference = "mypref";
    public static final String Password = "passwordKey";
    public static final String Rut = "rutKey";

    // TextView txtJson;
    ProgressDialog pd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        password = (TextView) findViewById(R.id.etPassword);
        rut = (TextView) findViewById(R.id.etRut);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Password)) {
            password.setText(sharedpreferences.getString(Password, ""));
        }
        if (sharedpreferences.contains(Rut)) {
            rut.setText(sharedpreferences.getString(Rut, ""));

        }

    }

    public void Save(View view) {
        String n = password.getText().toString();
        String e = rut.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Password, n);
        editor.putString(Rut, e);
        editor.commit();
        new JsonTask().execute("https://api.libreapi.cl/rut/validate?rut="+e);
    }

    public void clear(View view) {
        password = (TextView) findViewById(R.id.etPassword);
        rut = (TextView) findViewById(R.id.etRut);
        password.setText("");
        rut.setText("");

    }

    public void Get(View view) {
        password = (TextView) findViewById(R.id.etPassword);
        rut = (TextView) findViewById(R.id.etRut);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Password)) {
            password.setText(sharedpreferences.getString(Password, ""));
        }
        if (sharedpreferences.contains(Rut)) {
            rut.setText(sharedpreferences.getString(Rut, ""));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.i("INFO", "click onCreateOptionsMenu");
        return true;
    }


    
    private class JsonTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();
    
            pd = new ProgressDialog(LogInActivity.this);
            pd.setMessage("Please wait");
            pd.setCancelable(false);
            pd.show();
        }
    
        protected String doInBackground(String... params) {
    
    
            HttpURLConnection connection = null;
            BufferedReader reader = null;
    
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
    
    
                InputStream stream = connection.getInputStream();
    
                reader = new BufferedReader(new InputStreamReader(stream));
    
                StringBuffer buffer = new StringBuffer();
                String line = "";
    
                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-) 
    
                }
    
                return buffer.toString();
    
    
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (pd.isShowing()){
                pd.dismiss();
            }
            // txtJson.setText(result);
            Log.i("INFO", "onPostExecute ->"+result);
        }
    }
}
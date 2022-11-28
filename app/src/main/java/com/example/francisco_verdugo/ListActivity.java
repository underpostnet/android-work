package com.example.francisco_verdugo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.francisco_verdugo.ListAdapter.ListAdapter;

public class ListActivity extends AppCompatActivity {

    
    ListView list;

    String[] mainTitle = {
            "Juan Mercedes", "Maria Alpine", "Sebastian Haas"
    };
    String[] subtitle = {
            "Cargo: Jefe", "Cargo: operador", "Cargo: operador"
    };
    int[] imagesId = {
        R.drawable.avatar0,
        R.drawable.avatar1,
        R.drawable.avatar2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        this.renderListAdapter();
    }

    
    private void renderListAdapter() {
        ListAdapter adapter = new ListAdapter(this, mainTitle, subtitle, imagesId);
        list = findViewById(R.id.list_view_adapter);
        list.setAdapter(adapter);



        list.setOnItemClickListener((parent, view, position, id) -> {
            // TODO Auto-generated method stub
            Log.i("INFO", "ListAdapter.setOnItemClickListener -> id:"+id);


            // sonido

            // Intent intent = new Intent(MainActivity.this, MainActivity0.class);
            // intent.putExtra("title", mainTitle[(int)id]);
            // intent.putExtra("imageid", imagesId[(int)id]);
            // intent.putExtra("subtitle", subtitle[(int)id]);
            // startActivity(intent);


        });
    }
}
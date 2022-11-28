package com.example.francisco_verdugo.ListAdapter;

import android.app.Activity;  
 
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.ArrayAdapter;  
import android.widget.ImageView;  
import android.widget.TextView;

import com.example.francisco_verdugo.R;

public class ListAdapter extends ArrayAdapter<String> {  

    private final Activity context;
    private final String[] maintitle;
    private final String[] subtitle;
    private final int[] imgid;
 
    public ListAdapter(Activity context, String[] maintitle, String[] subtitle, int[] imgid) {
        super(context, R.layout.list_card, maintitle);
        // TODO Auto-generated constructor stub  

        this.context=context;
        this.maintitle=maintitle;
        this.subtitle=subtitle;
        this.imgid=imgid;  
 
    }  
 
    public View getView(int position,View view,ViewGroup parent) {  
        LayoutInflater inflater=context.getLayoutInflater();  
        View rowView=inflater.inflate(R.layout.list_card, null, true);
 
        TextView titleText = (TextView) rowView.findViewById(R.id.title_list);  
        ImageView imageView = (ImageView) rowView.findViewById(R.id.image_list);  
        TextView subtitleText = (TextView) rowView.findViewById(R.id.text_list);  
 
        titleText.setText(maintitle[position]);  
        imageView.setImageResource(imgid[position]);  
        subtitleText.setText(subtitle[position]);  
 
        return rowView;  
 
    };  
}
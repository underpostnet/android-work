package com.example.francisco_verdugo.Formula1Item;

import android.app.Activity;  
 
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.ArrayAdapter;  
import android.widget.ImageView;  
import android.widget.TextView;

import com.example.francisco_verdugo.R;

public class Formula1ItemAdapter extends ArrayAdapter<String> {  

    private final Activity context;
    private final String[] maintitle;
    private final String[] subtitle;
    private final int[] imgid;
 
    public Formula1ItemAdapter(Activity context, String[] maintitle, String[] subtitle, int[] imgid) {
        super(context, R.layout.formula1_card, maintitle);
        // TODO Auto-generated constructor stub  

        this.context=context;
        this.maintitle=maintitle;
        this.subtitle=subtitle;
        this.imgid=imgid;  
 
    }  
 
    public View getView(int position,View view,ViewGroup parent) {  
        LayoutInflater inflater=context.getLayoutInflater();  
        View rowView=inflater.inflate(R.layout.formula1_card, null,true);
 
        TextView titleText = (TextView) rowView.findViewById(R.id.title_formula_1);  
        ImageView imageView = (ImageView) rowView.findViewById(R.id.image_formula_1);  
        TextView subtitleText = (TextView) rowView.findViewById(R.id.text_formula_1);  
 
        titleText.setText(maintitle[position]);  
        imageView.setImageResource(imgid[position]);  
        subtitleText.setText(subtitle[position]);  
 
        return rowView;  
 
    };  
}
package com.example.francisco_verdugo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import java.util.ArrayList;

public class GfxActivity extends AppCompatActivity {
    private BarChart barChart;
    private String []month= new String[] {"Maria", "Juan"};
    private int []sale= new int[] {60, 40};
    private int []colors= new int[] {Color.GREEN, Color.YELLOW};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gfx);
        barChart = (BarChart) findViewById(R.id.charts);
        createCharts();
    }
    private Chart getSameChart(Chart chart, String description, int textColor,
                               int background){
        chart.getDescription().setText(description);
        chart.getDescription().setTextSize(15);
        chart.setBackgroundColor(background);
        return chart;
    }
    private void legend (Chart chart) {
        Legend legend= chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        ArrayList<LegendEntry> entries = new ArrayList<>();
        for (int i=0; i< month.length; i++) {
            LegendEntry entry = new LegendEntry();
            entry.formColor = colors[i];
            entry.label = month[i];
            entries.add(entry);
        }
        legend.setCustom(entries);
    }
    private ArrayList <BarEntry> getBarEntries(){
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i=0; i< month.length; i++)
            entries.add(new BarEntry(i,sale[i]));
        return entries;
    }
    private void axisX (XAxis axis){
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setValueFormatter(new IndexAxisValueFormatter(month));
    }

    private void axisLeft (YAxis axis){
        axis.setEnabled(false);
    }
    private void axisRight (YAxis axis){
        axis.setEnabled(false);
    }
    public void createCharts(){
        barChart=(BarChart)getSameChart(barChart, "Serie", Color.RED,
                Color.CYAN);
        barChart.setDrawBarShadow(true);
        barChart.setData(getBarData());
        barChart.invalidate();
        barChart.setDrawGridBackground(true);
        axisX(barChart.getXAxis());
        axisLeft(barChart.getAxisLeft());
        axisRight(barChart.getAxisRight());
    }
    private DataSet getData(DataSet dataSet){
        dataSet.setColors(colors);
        dataSet.setValueTextSize(Color.WHITE);
        dataSet.setValueTextSize(10);
        return dataSet;
    }
    private BarData getBarData (){
        BarDataSet barDataSet= (BarDataSet) getData (new
                BarDataSet(getBarEntries(), ""));
        barDataSet.setBarShadowColor(Color.GRAY);
        BarData barData= new BarData(barDataSet);
        barData.setBarWidth(0.45f);
        return barData;
    }

}
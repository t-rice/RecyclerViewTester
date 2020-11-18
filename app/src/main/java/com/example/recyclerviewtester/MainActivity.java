package com.example.recyclerviewtester;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list_view);

        final String[] string = new String[] {"sdfsdfsdf", "fsdfsdfs", "sdfsdfsdf", "cvcvcvcv", "cfsfcvcxv", "sdfsdfsdf", "fsdfsdfs", "sdfsdfsdf", "cvcvcvcv", "cfsfcvcxv", "sdfsdfsdf", "fsdfsdfs", "sdfsdfsdf", "cvcvcvcv", "cfsfcvcxv"};
        @SuppressLint("ResourceType") ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_xml, string) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View rowView = inflater.inflate(R.layout.list_xml, parent, false);
                rowView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("HAHAHA", "OYAEBU");
                    }
                });
                TextView textView = (TextView) rowView.findViewById(R.id.oyaebu);
                textView.setText(string[position]);
                return rowView;
            }
        };


        listView.setAdapter(adapter);
    }
}
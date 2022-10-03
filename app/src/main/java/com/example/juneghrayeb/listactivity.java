package com.example.juneghrayeb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listactivity extends AppCompatActivity {

    ListView ListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listactivity);

        ListView =(ListView) findViewById(R.id.listView);

        //make an array list
        ArrayList<String> arrayList = new ArrayList<>();

        //add items to array list
        arrayList.add("banana");
        arrayList.add("apple");

        //initialize the adapter
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);



        // connect adapter to array
        ListView.setAdapter(arrayAdapter);

        //handle items clicks
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(listactivity.this, "Clicked item"+ i+""+arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
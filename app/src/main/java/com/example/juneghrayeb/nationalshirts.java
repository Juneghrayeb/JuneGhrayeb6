package com.example.juneghrayeb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class nationalshirts extends AppCompatActivity implements RecyclerViewInterface {
    ArrayList<Nationalmodel> nationalmodels = new ArrayList<>();
    int[] nationalImages = {R.drawable.brazilhome,R.drawable.argentinahome,
            R.drawable.portugal2022,R.drawable.france,R.drawable.england};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nationalshirts);
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        setNationalmodels();
        NK_RecyclerviewAdapter adapter = new NK_RecyclerviewAdapter(this,nationalmodels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    private void setNationalmodels(){
        String[] nationalnames = getResources().getStringArray(R.array.national_kits_full_txt);
        for (int i =0 ; i<nationalnames.length;i++){
            nationalmodels.add(new Nationalmodel(nationalnames[i],nationalImages[i]));
        }
    }


    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(nationalshirts.this, cartsnationalshirts.class);
        intent.putExtra("Name",nationalmodels.get(position).getNationalkitsname());
        intent.putExtra("IMAGE",nationalmodels.get(position).getImage());
        startActivity(intent);



    }

}

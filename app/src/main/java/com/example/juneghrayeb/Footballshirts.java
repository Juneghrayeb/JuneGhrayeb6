package com.example.juneghrayeb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Footballshirts extends AppCompatActivity implements RecyclerViewInterface2{


    ArrayList<Footballshirtsmodel> footballshirtsmodels = new ArrayList<>();
    int[] footballshirtsimages = {R.drawable.braca,R.drawable.realmadrid,
            R.drawable.psg,R.drawable.liverpool,R.drawable.manutd};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footballshirts);





        RecyclerView recyclerView =findViewById(R.id.mFSReceylerView);
        setFootballshirtsmodels();
        FS_RecyclerviewAdapter adapter = new FS_RecyclerviewAdapter(this,footballshirtsmodels , this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void setFootballshirtsmodels(){
        String[] footballshirtsnames = getResources().getStringArray(R.array.football_shirts_full_txt);
        for (int k =0 ; k<footballshirtsnames.length;k++){
            footballshirtsmodels.add(new Footballshirtsmodel(footballshirtsnames[k],footballshirtsimages[k]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Footballshirts.this,cartsFootballshirts.class);
        intent.putExtra("NAME",footballshirtsmodels.get(position).getFootballshirtsname());
        intent.putExtra("IMAGE", footballshirtsmodels.get(position).getImage());

        startActivity(intent);

    }

}
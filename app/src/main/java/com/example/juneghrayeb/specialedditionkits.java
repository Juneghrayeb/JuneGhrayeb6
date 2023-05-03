package com.example.juneghrayeb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class specialedditionkits extends AppCompatActivity implements RecylcerViewInterface3 {

    ArrayList <SpecialEdditionModel> specialEdditionModels = new ArrayList<>();
    int [] specialEdditionImages = {R.drawable.mardona,R.drawable.ronaldo,R.drawable.messi,R.drawable.madridspicialeddiotion,
    R.drawable.specialpsg};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialedditionkits);
        RecyclerView recyclerView = findViewById(R.id.mSERecycleView);

        setSpecialEdditionModels();

        SE_RecyclerviewAdapter adapter = new SE_RecyclerviewAdapter(this,specialEdditionModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setSpecialEdditionModels(){
        String[] SpecialEdditionName = getResources().getStringArray(R.array.special_eddition_full_text) ;


        for (int i = 0; i<SpecialEdditionName.length;i++){
            specialEdditionModels.add(new SpecialEdditionModel(SpecialEdditionName[i],specialEdditionImages[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(specialedditionkits.this,cartsspecialeddition.class);
        intent.putExtra("NAME",specialEdditionModels.get(position).getSpecialEdditionName());
        intent.putExtra("IMAGE",specialEdditionModels.get(position).getImage());
        startActivity(intent);

    }
}
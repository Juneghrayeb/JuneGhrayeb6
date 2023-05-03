package com.example.juneghrayeb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class cartsnationalshirts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartsnationalshirts);
        String name = getIntent().getStringExtra("Name");
        int image = getIntent().getIntExtra("IMAGE",0);

        TextView nameTextView = findViewById(R.id.Brazilkit);
        ImageView NK_Image = findViewById(R.id.brazilimage);

        nameTextView.setText(name);
        NK_Image.setImageResource(image);
    }
}
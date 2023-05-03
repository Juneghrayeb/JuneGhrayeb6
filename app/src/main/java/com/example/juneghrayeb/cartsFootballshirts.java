package com.example.juneghrayeb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class cartsFootballshirts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carts_footballshirts);

        String name = getIntent().getStringExtra("NAME");
        int image = getIntent().getIntExtra("IMAGE",0);

        TextView nameTextView = findViewById(R.id.footballteamname);
        ImageView FS_Image = findViewById(R.id.barcakit);
    }
}
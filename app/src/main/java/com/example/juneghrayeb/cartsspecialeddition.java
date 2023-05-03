package com.example.juneghrayeb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class cartsspecialeddition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartsspecialeddition);
        String name = getIntent().getStringExtra("NAME");
        int image = getIntent().getIntExtra("IMAGE",0);

        TextView nameTextView = findViewById(R.id.Mardona2);
        ImageView Image =findViewById(R.id.Mardonajpg) ;

         nameTextView.setText(name);
         Image.setImageResource(image);
    }
}
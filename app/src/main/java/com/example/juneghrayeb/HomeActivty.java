package com.example.juneghrayeb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivty extends AppCompatActivity {
    EditText editTextNumber,editTextNumber2;
    Button ButtonPlus,ButtonMinus;
    TextView textViewAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activty);

        editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);

        ButtonPlus = findViewById(R.id.ButtonPlus);
        ButtonMinus = findViewById(R.id.ButtonMinus);

        textViewAnswer = findViewById(R.id.textViewAnswer);
    }

    public void plus(View view) {
        if (editTextNumber.getText().toString().equals("")||editTextNumber2.getText().toString().equals(""));
            Toast.makeText(this, "Empty Email", Toast.LENGTH_LONG).show();
        double number1 = Double.parseDouble(editTextNumber.getText().toString());
        double number2 = Double.parseDouble(editTextNumber2.getText().toString());
        textViewAnswer.setText(number1 +number2+"");
    }

    public void minus(View view) {
        if (editTextNumber.getText().toString().equals("")||editTextNumber2.getText().toString().equals(""));
        double number1 = Double.parseDouble(editTextNumber.getText().toString());
        double number2 = Double.parseDouble(editTextNumber2.getText().toString());
        textViewAnswer.setText(number1 -number2+"");
    }
// this method loads the menu design into this activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    //handle options menu click events

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help_menu:
                Toast.makeText(this, "Help clicked", Toast.LENGTH_SHORT).show();//open help activity when the help activity is selected
                // this is from where, and the second parameter is to where
                Intent i = new Intent(this, listactivity.class);
                startActivity(i);
                break;

            case R.id.setting_menu:
                Toast.makeText(this, "Setting clicked", Toast.LENGTH_SHORT).show();
                Intent x = new Intent(this, setting.class);
                startActivity(x);
                break;

            case R.id.home_menu:
                Toast.makeText(this, "Home page clicked", Toast.LENGTH_SHORT).show();
                Intent k = new Intent(this, HomeActivty.class);
                startActivity(k);
                break;


        }
        return true;
    }


    }



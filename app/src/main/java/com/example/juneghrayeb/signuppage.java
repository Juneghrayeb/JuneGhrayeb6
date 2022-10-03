package com.example.juneghrayeb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signuppage extends AppCompatActivity {

    private TextView  SignuppageS;
    private Button SignS,CancelS;
    private EditText EmailS,PasswordS;

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);

        EmailS = findViewById(R.id.EmailS);
        PasswordS = findViewById(R.id.PasswordS);
        SignS = findViewById(R.id.SignS);
        CancelS = findViewById(R.id.CancelS);

        preferences = getSharedPreferences("userinfo",0);

    }
    public void register(View view){
        String input_mail = EmailS.getText().toString();
        String input_password = PasswordS.getText().toString();
        if(input_mail.length()>0) {
            //open preferences file
            SharedPreferences.Editor editor = preferences.edit();
            //save key ,value data
            editor.putString("username", input_mail);
            editor.putString("password", input_password);

            editor.apply();
            Toast.makeText(this, "user registered!", Toast.LENGTH_SHORT).show();
            Intent intent_main = new Intent(this, HomeActivty.class);
            startActivity(intent_main);
        }
        else
        {
         Toast.makeText(this,"Empty values, Please insert!",Toast.LENGTH_SHORT).show();
        }
    }
    public void cancel(View view){
        Intent intent_main = new Intent(this,MainActivity.class);
        startActivity(intent_main);
    }

}
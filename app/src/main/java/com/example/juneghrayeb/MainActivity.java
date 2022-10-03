package com.example.juneghrayeb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextTextPassword, editTextTextEmailAddress;
    Button buttonlogin, buttonsignup;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);

        buttonlogin = findViewById(R.id.buttonlogin);
        buttonsignup = findViewById(R.id.buttonsignup);

        preferences = getSharedPreferences("userinfo", 0);
    }

    public void login(View view) {
        if (editTextTextEmailAddress.getText().toString().equals(""))
            Toast.makeText(this, "Empty Email", Toast.LENGTH_LONG).show();

        else if (editTextTextPassword.getText().toString().equals(""))
            Toast.makeText(this, "Empty Password", Toast.LENGTH_LONG).show();
// THIS LINE GETS THE REGISTERED EMAIL AND PASSWORD , IN CASE NO USER WAS REGISTERED EMPTY STRING IS RETURNED
        String input_mail = editTextTextEmailAddress.getText().toString();
        String input_password = editTextTextPassword.getText().toString();

        String registeredMail = preferences.getString("username", "");
        String registeredPassword = preferences.getString("username", "");

        if (input_mail.equals(registeredMail) && input_password.equals(registeredPassword)) {
            Intent i_mail = new Intent(this, HomeActivty.class);
            startActivity(i_mail);
        } else {
            Toast.makeText(this, "incorrect credentials!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onBackPressed() {//is called when the user clicks on the back button
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Back button was pressed");
        dialog.setMessage("are you sure you want to exit");
        //in case the user choose no nothing happens and the dialog closes
        dialog.setNegativeButton("no", null);
        //when the user clicks on the yes button the application closes
        dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });
        dialog.setIcon(R.drawable.ic_baseline_close_24);
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }

    public void signup(View view) {
        Intent i_signup = new Intent(this, signuppage.class);
        startActivity(i_signup);

    }
}


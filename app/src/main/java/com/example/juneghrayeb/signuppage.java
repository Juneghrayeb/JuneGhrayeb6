package com.example.juneghrayeb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signuppage extends AppCompatActivity {

    private TextView  signuppage;
    private Button SignS,CancelS;
    private EditText EmailS,PasswordS;

    private FirebaseAuth mAuth;
    SharedPreferences preferences;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);

        mAuth = FirebaseAuth.getInstance();
        EmailS = findViewById(R.id.EmailS);
        PasswordS = findViewById(R.id.PasswordS);
        SignS = findViewById(R.id.SignS);
        CancelS = findViewById(R.id.CancelS);

        preferences = getSharedPreferences("userinfo", 0);
    }
        public void signup(String email, String password){
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("HANEEN", "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent_main = new Intent(signuppage.this, MainActivity.class);
                                startActivity(intent_main);

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("Firebase", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(signuppage.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }



    public void signup(View view){
        this.view = view;
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
            signup(input_mail,input_password);

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
package com.example.juneghrayeb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.ListActivity;
import android.app.PendingIntent;
import android.content.Context;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activty);
        Intent notification = new Intent(this, Receiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this, 1, notification, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager)
                this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), 3000, pendingIntent);


    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {


            case R.id.home_menu:
                Intent z = new Intent(this,HomeActivty.class);
                startActivity(z);
                break;
            case R.id.camraactivty_menu:
                Intent m = new Intent(this,camraactivity.class);
                startActivity(m);
                break;



        }

        return true;
    }

    public void goTonationalshirts(View view) {
        Intent p = new Intent(this, nationalshirts.class);
        startActivity(p);
    }

    public void goToFootballShirts(View view){
        Intent k = new Intent(this,Footballshirts.class);
        startActivity(k);
    }
    public void goTospecialeddition(View view){
        Intent i = new Intent(this,specialedditionkits.class);
        startActivity(i);
    }
}




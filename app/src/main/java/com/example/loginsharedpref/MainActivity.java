package com.example.loginsharedpref;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView name = findViewById(R.id.tv_namaMain);

        name.setText(Preferences.getLoggedInUser(getBaseContext()));



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.logout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.btnLogout:{
                Preferences.clearLoggedInUser(getBaseContext());
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();
            }
        }

        return super.onOptionsItemSelected(item);
    }

}
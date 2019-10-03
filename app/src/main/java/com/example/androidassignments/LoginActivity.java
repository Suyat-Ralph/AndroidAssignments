package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "LoginActivity";
    private Button LoginButton;
    private TextView emailTextview;

    private SharedPreferences prefs;
    private SharedPreferences.Editor edit;
    private String emailKey = "Email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        emailTextview = findViewById(R.id.email);
        LoginButton = findViewById(R.id.loginb);

        prefs = getSharedPreferences(ACTIVITY_NAME, Context.MODE_PRIVATE );
        edit = prefs.edit();

        String defaultemail = prefs.getString("DefaultEmail", "Email@domain.com");
        String lastemail = prefs.getString(emailKey,"");
        emailTextview.setText(defaultemail);
        emailTextview.setText(lastemail);
        edit.clear();
        edit.putString(emailKey ,emailTextview.getText().toString());
        edit.commit();


        LoginButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.i(ACTIVITY_NAME, "Ya Clicked LoginButton");
                edit.putString(emailKey , emailTextview.getText().toString());
                edit.commit();

                String newEmail = prefs.getString(emailKey, " ");
                Log.i(ACTIVITY_NAME, newEmail);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");

    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

}

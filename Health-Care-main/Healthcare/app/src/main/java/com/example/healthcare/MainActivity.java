package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }
    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser mUser = mAuth.getCurrentUser();
        if(mUser != null){
            startActivity(new Intent(MainActivity.this,Home.class));
        }
        else{
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
            finish();
        }
    }

}
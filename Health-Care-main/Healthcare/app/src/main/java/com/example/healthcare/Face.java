package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Face extends AppCompatActivity {

    public static final String id = "com.example.healthcare.id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face);
    }
    public void vai_C(View view){
        Intent i = new Intent(Face.this,BuyNow.class);
        i.putExtra(id,"CFacewash");
        startActivity(i);
    }
    public void tea_fw(View view){
        Intent i = new Intent(Face.this,BuyNow.class);
        i.putExtra(id,"teatree_fw");
        startActivity(i);
    }
    public void A_fw(View view){
        Intent i = new Intent(Face.this,BuyNow.class);
        i.putExtra(id,"A_fw");
        startActivity(i);
    }
    public void ub_fw(View view){
        Intent i = new Intent(Face.this,BuyNow.class);
        i.putExtra(id,"UbtanFaceWash");
        startActivity(i);
    }
    public void t_fw(View view){
        Intent i = new Intent(Face.this,BuyNow.class);
        i.putExtra(id,"teatree");
        startActivity(i);
    }
    public void U_fw(View view){
        Intent i = new Intent(Face.this,BuyNow.class);
        i.putExtra(id,"ubtonscrub");
        startActivity(i);
    }


}
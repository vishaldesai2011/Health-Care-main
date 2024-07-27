package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Hair extends AppCompatActivity {
    public static final String id = "com.example.healthcare.id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair);
    }
    public void oni_s(View view){
        Intent in = new Intent(Hair.this, BuyNow.class);
        in.putExtra(id,"OnionOil");
        startActivity(in);

    }
    public void tea_s(View view){
        Intent in = new Intent(Hair.this, BuyNow.class);
        in.putExtra(id,"tea_s");
        startActivity(in);

    }
    public void hena_s(View view){
        Intent in = new Intent(Hair.this, BuyNow.class);
        in.putExtra(id,"hina_s");
        startActivity(in);

    }
    public void r_s(View view){
        Intent in = new Intent(Hair.this, BuyNow.class);
        in.putExtra(id,"rice_s");
        startActivity(in);

    }
    public void am_s(View view){
        Intent in = new Intent(Hair.this, BuyNow.class);
        in.putExtra(id,"amla_s");
        startActivity(in);

    }
    public void alm_s(View view){
        Intent in = new Intent(Hair.this, BuyNow.class);
        in.putExtra(id,"almond_s");
        startActivity(in);

    }

}
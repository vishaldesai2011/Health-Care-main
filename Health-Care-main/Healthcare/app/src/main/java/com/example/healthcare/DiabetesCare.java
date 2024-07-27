package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DiabetesCare extends AppCompatActivity {
    public static final String id = "com.example.healthcare.id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetes_care);
//        Prod 1
        Button glucose = (Button)findViewById(R.id.disprin);
        glucose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(DiabetesCare.this,BuyNow.class);
                inte.putExtra(id,"glucose");
                startActivity(inte);
            }
        });
        ImageView img_glucose = (ImageView)findViewById(R.id.glucose_strip);
        img_glucose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(DiabetesCare.this,BuyNow.class);
                inte.putExtra(id,"glucose");
                startActivity(inte);
            }
        });
//      prod 2
        Button meter = (Button)findViewById(R.id.gal);
        meter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(DiabetesCare.this,BuyNow.class);
                inte.putExtra(id,"meter");
                startActivity(inte);
            }
        });
        ImageView img_meter = (ImageView)findViewById(R.id.img_gal);
        img_meter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(DiabetesCare.this,BuyNow.class);
                inte.putExtra(id,"meter");
                startActivity(inte);
            }
        });
        //      prod 3
        Button sweetner = (Button)findViewById(R.id.zandu);
        sweetner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(DiabetesCare.this,BuyNow.class);
                inte.putExtra(id,"sweetner");
                startActivity(inte);
            }
        });
        ImageView img_sweetner = (ImageView)findViewById(R.id.img_zandu);
        img_sweetner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(DiabetesCare.this,BuyNow.class);
                inte.putExtra(id,"sweetner");
                startActivity(inte);
            }
        });

        //      prod 4
        Button protin  = (Button)findViewById(R.id.painout);
        protin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(DiabetesCare.this,BuyNow.class);
                inte.putExtra(id,"protin");
                startActivity(inte);
            }
        });
        ImageView img_protin = (ImageView)findViewById(R.id.img_painout);
        img_protin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(DiabetesCare.this,BuyNow.class);
                inte.putExtra(id,"protin");
                startActivity(inte);
            }
        });
    }
}
package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CovidProtection extends AppCompatActivity {
    public static final String id = "com.example.healthcare.id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_protection);

        Button btn_VaitaminC = (Button)findViewById(R.id.painout);
        btn_VaitaminC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(CovidProtection.this,BuyNow_Medicines.class);
                inte.putExtra(id,"med_VaitaminC");
                startActivity(inte);
            }
        });
        ImageView img_VaitaminC = (ImageView) findViewById(R.id.img_painout);
        img_VaitaminC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(CovidProtection.this,BuyNow_Medicines.class);
                inte.putExtra(id,"med_VaitaminC");
                startActivity(inte);
            }
        });

        Button btn_thermometer = (Button)findViewById(R.id.disprin);
        btn_thermometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(CovidProtection.this,BuyNow.class);
                inte.putExtra(id,"thermometer");
                startActivity(inte);
            }
        });

        ImageView img_thermometer = (ImageView)findViewById(R.id.img_disprin);
        img_thermometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(CovidProtection.this,BuyNow.class);
                inte.putExtra(id,"thermometer");
                startActivity(inte);
            }
        });
        Button btn_senitizer = (Button)findViewById(R.id.gal);
        btn_senitizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(CovidProtection.this,BuyNow.class);
                inte.putExtra(id,"img_senitizer");
                startActivity(inte);
            }
        });

        ImageView img_senitizer = (ImageView)findViewById(R.id.img_gal);
        img_senitizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(CovidProtection.this,BuyNow.class);
                inte.putExtra(id,"img_senitizer");
                startActivity(inte);
            }
        });

        Button btn_mask = (Button)findViewById(R.id.zandu);
        btn_mask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(CovidProtection.this,BuyNow.class);
                inte.putExtra(id,"mask");
                startActivity(inte);
            }
        });

        ImageView img_mask = (ImageView)findViewById(R.id.img_zandu);
        img_mask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(CovidProtection.this,BuyNow.class);
                inte.putExtra(id,"mask");
                startActivity(inte);
            }
        });

        Button btn_zink = (Button)findViewById(R.id.chav);
        btn_zink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(CovidProtection.this,BuyNow.class);
                inte.putExtra(id,"med_zink");
                startActivity(inte);
            }
        });

        ImageView img_zink = (ImageView)findViewById(R.id.img_chav);
        img_zink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(CovidProtection.this,BuyNow.class);
                inte.putExtra(id,"med_zink");
                startActivity(inte);
            }
        });

        Button btn_vaitamin_b = (Button)findViewById(R.id.tulsidrop);
        btn_vaitamin_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(CovidProtection.this,BuyNow.class);
                inte.putExtra(id,"med_vaitamin_B12");
                startActivity(inte);
            }
        });

        ImageView img_vaitamin_b= (ImageView)findViewById(R.id.img_tulsidrop);
        img_vaitamin_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(CovidProtection.this,BuyNow.class);
                inte.putExtra(id,"med_vaitamin_B12");
                startActivity(inte);
            }
        });

    }
}
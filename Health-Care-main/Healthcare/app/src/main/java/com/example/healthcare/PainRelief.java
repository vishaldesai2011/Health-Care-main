package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PainRelief extends AppCompatActivity {
    public static final String id = "com.example.healthcare.id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pain_relief);
//prod 1
        Button disp  = (Button)findViewById(R.id.disprin);
        disp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(PainRelief.this,BuyNow.class);
                inte.putExtra(id,"disprin");
                startActivity(inte);
            }
        });
        ImageView img_disp = (ImageView)findViewById(R.id.img_disprin);
        img_disp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(PainRelief.this,BuyNow.class);
                inte.putExtra(id,"disprin");
                startActivity(inte);
            }
        });
//prod 2
        Button gal  = (Button)findViewById(R.id.gal);
        gal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(PainRelief.this,BuyNow.class);
                inte.putExtra(id,"gal");
                startActivity(inte);
            }
        });
        ImageView img_gal = (ImageView)findViewById(R.id.img_gal);
        img_gal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(PainRelief.this,BuyNow.class);
                inte.putExtra(id,"gal");
                startActivity(inte);
            }
        });
        //prod 3
        Button zandu  = (Button)findViewById(R.id.zandu);
        zandu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(PainRelief.this,BuyNow.class);
                inte.putExtra(id,"zandu");
                startActivity(inte);
            }
        });
        ImageView img_zandu = (ImageView)findViewById(R.id.img_zandu);
        img_zandu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(PainRelief.this,BuyNow.class);
                inte.putExtra(id,"zandu");
                startActivity(inte);
            }
        });

        //prod 4
        Button painout  = (Button)findViewById(R.id.painout);
        painout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(PainRelief.this,BuyNow.class);
                inte.putExtra(id,"painout");
                startActivity(inte);
            }
        });
        ImageView img_painout = (ImageView)findViewById(R.id.img_painout);
        img_painout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(PainRelief.this,BuyNow.class);
                inte.putExtra(id,"painout");
                startActivity(inte);
            }
        });

        //prod 5
        Button dr  = (Button)findViewById(R.id.dr);
        dr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(PainRelief.this,BuyNow.class);
                inte.putExtra(id,"dr");
                startActivity(inte);
            }
        });
        ImageView img_dr = (ImageView)findViewById(R.id.img_dr);
        img_dr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(PainRelief.this,BuyNow.class);
                inte.putExtra(id,"dr");
                startActivity(inte);
            }
        });

        //prod 6
        Button iodex  = (Button)findViewById(R.id.iodex);
        iodex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(PainRelief.this,BuyNow.class);
                inte.putExtra(id,"iodex");
                startActivity(inte);
            }
        });
        ImageView img_iodex = (ImageView)findViewById(R.id.img_iodex);
        img_iodex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(PainRelief.this,BuyNow.class);
                inte.putExtra(id,"iodex");
                startActivity(inte);
            }
        });

        //prod 7
        Button zandu_oil  = (Button)findViewById(R.id.chav);
        zandu_oil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(PainRelief.this,BuyNow.class);
                inte.putExtra(id,"zandu_oil");
                startActivity(inte);
            }
        });
        ImageView img_zandu_oil = (ImageView)findViewById(R.id.img_chav);
        img_zandu_oil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(PainRelief.this,BuyNow.class);
                inte.putExtra(id,"zandu_oil");
                startActivity(inte);
            }
        });

        //prod 8
        Button rumaliya  = (Button)findViewById(R.id.tulsidrop);
        rumaliya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(PainRelief.this,BuyNow.class);
                inte.putExtra(id,"rumaliya");
                startActivity(inte);
            }
        });
        ImageView img_rumaliya = (ImageView)findViewById(R.id.img_tulsidrop);
        img_rumaliya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(PainRelief.this,BuyNow.class);
                inte.putExtra(id,"rumaliya");
                startActivity(inte);
            }
        });
    }
}
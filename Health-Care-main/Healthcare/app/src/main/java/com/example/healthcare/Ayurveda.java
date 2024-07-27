package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ayurveda extends AppCompatActivity {
    public static final String id = "com.example.healthcare.id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayurveda);
    }
    public void img_honitus(View view){
        Intent inte = new Intent(Ayurveda.this,BuyNow.class);
        inte.putExtra(id,"Honitus");
        startActivity(inte);
    }
    public void honitus(View view){
        Intent inte = new Intent(Ayurveda.this,BuyNow.class);
        inte.putExtra(id,"Honitus");
        startActivity(inte);
    }

    public void img_hajmola(View view){
        Intent inte = new Intent(Ayurveda.this,BuyNow.class);
        inte.putExtra(id,"hajmola");
        startActivity(inte);
    }
    public void hajmola(View view){
        Intent inte = new Intent(Ayurveda.this,BuyNow.class);
        inte.putExtra(id,"hajmola");
        startActivity(inte);
    }

    public void hajmola1(View view){
        Intent inte = new Intent(Ayurveda.this,BuyNow.class);
        inte.putExtra(id,"hajmola1");
        startActivity(inte);
    }
    public void hajmola11(View view){
        Intent inte = new Intent(Ayurveda.this,BuyNow.class);
        inte.putExtra(id,"hajmola1");
        startActivity(inte);
    }

    public void img_ashwagandha(View view){
        Intent inte = new Intent(Ayurveda.this,BuyNow.class);
        inte.putExtra(id,"Ashwagandha");
        startActivity(inte);
    }
    public void ashwagandha(View view){
        Intent inte = new Intent(Ayurveda.this,BuyNow.class);
        inte.putExtra(id,"Ashwagandha");
        startActivity(inte);
    }

    public void chaw(View view){
        Intent inte = new Intent(Ayurveda.this,BuyNow.class);
        inte.putExtra(id,"Chyawanprash");
        startActivity(inte);
    }
    public void td(View view){
        Intent inte = new Intent(Ayurveda.this,BuyNow.class);
        inte.putExtra(id,"tulsidrop");
        startActivity(inte);
    }
}
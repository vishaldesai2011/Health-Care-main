package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AllProducts extends AppCompatActivity {
    public static final String id = "com.example.healthcare.id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);

    }
    public void dabar(View view){
        Intent i = new Intent(AllProducts.this,BuyNow.class);
        i.putExtra(id,"Honitus");
        startActivity(i);
    }
    public void hajmola(View view){
        Intent i = new Intent(AllProducts.this,BuyNow.class);
        i.putExtra(id,"hajmola");
        startActivity(i);
    }

    public void ashwagandha(View view){
        Intent i = new Intent(AllProducts.this,BuyNow.class);
        i.putExtra(id,"Ashwagandha");
        startActivity(i);
    }

    public void chaw(View view){
        Intent i = new Intent(AllProducts.this,BuyNow.class);
        i.putExtra(id,"Chyawanprash");
        startActivity(i);
    }
    public void td(View view){
        Intent i = new Intent(AllProducts.this,BuyNow.class);
        i.putExtra(id,"tulsidrop");
        startActivity(i);
    }
    public void bg(View view){
        Intent i = new Intent(AllProducts.this,BuyNow.class);
        i.putExtra(id,"glucose");
        startActivity(i);
    }
    public void strip(View view){
        Intent i = new Intent(AllProducts.this,BuyNow.class);
        i.putExtra(id,"meter");
        startActivity(i);
    }
    public void sugar(View view){
        Intent i = new Intent(AllProducts.this,BuyNow.class);
        i.putExtra(id,"sweetner");
        startActivity(i);
    }
    public void prot(View view){
        Intent i = new Intent(AllProducts.this,BuyNow.class);
        i.putExtra(id,"protin");
        startActivity(i);
    }
    public void dis(View view){
        Intent i = new Intent(AllProducts.this,BuyNow.class);
        i.putExtra(id,"disprin");
        startActivity(i);
    }
    public void pain_jel(View view){
        Intent i = new Intent(AllProducts.this,BuyNow.class);
        i.putExtra(id,"gal");
        startActivity(i);
    }
    public void zandu(View view){
        Intent i = new Intent(AllProducts.this,BuyNow.class);
        i.putExtra(id,"zandu");
        startActivity(i);
    }

    public void paino(View view){
        Intent i = new Intent(AllProducts.this,BuyNow.class);
        i.putExtra(id,"painout");
        startActivity(i);
    }

    public void dr(View view){
        Intent i = new Intent(AllProducts.this,BuyNow.class);
        i.putExtra(id,"dr");
        startActivity(i);
    }
    public void iodex(View view){
        Intent i = new Intent(AllProducts.this,BuyNow.class);
        i.putExtra(id,"iodex");
        startActivity(i);
    }
    public void oil(View view){
        Intent i = new Intent(AllProducts.this,BuyNow.class);
        i.putExtra(id,"zandu_oil");
        startActivity(i);
    }
    public void rul(View view){
        Intent i = new Intent(AllProducts.this,BuyNow.class);
        i.putExtra(id,"rumaliya");
        startActivity(i);
    }

}
package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class BuyNow_Medicines extends AppCompatActivity {
    String txt;
    public static final String id = "com.example.healthcare.id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_now_medicines);
        TextView t = (TextView)findViewById(R.id.title_buy);
        TextView t1 = (TextView)findViewById(R.id.sub_title);
        TextView t2 = (TextView)findViewById(R.id.price12);
        TextView t3 = (TextView)findViewById(R.id.desc);
        TextView t4 = (TextView)findViewById(R.id.rating);
        TextView t5 = (TextView)findViewById(R.id.side1);
        TextView t6 = (TextView)findViewById(R.id.side2);
        TextView t7 = (TextView)findViewById(R.id.side3);
        TextView t8 = (TextView)findViewById(R.id.side4);
        Intent intent = getIntent();
        txt =intent.getStringExtra(CovidProtection.id);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(txt);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot item : snapshot.getChildren()){
                    if(item.exists()){
                        Map mp = (Map)snapshot.getValue();
                        t.setText(mp.get("title").toString());
                        t1.setText(mp.get("sub_title").toString());
                        String imge = mp.get("image").toString();
                        t2.setText(mp.get("price").toString());
                        t3.setText(mp.get("desc").toString());
                        t4.setText(mp.get("rating").toString());
                        t5.setText("1."+mp.get("side1").toString());
                        t6.setText("2."+mp.get("side2").toString());
                        t7.setText("3."+mp.get("side3").toString());
                        t8.setText("4."+mp.get("side4").toString());

                        String uri = "@drawable/"+imge;
                        int imgres = getResources().getIdentifier(uri,null,getPackageName());
                        ImageView im = (ImageView) findViewById(R.id.imge);
                        Drawable res = getResources().getDrawable(imgres);
                        im.setImageDrawable(res);


                    }
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void buy(View view){
        Intent checkout = new Intent(BuyNow_Medicines.this,Checkout.class);
        checkout.putExtra(id,txt);
        startActivity(checkout);
    }

}
package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class BuyNow extends AppCompatActivity {
    public static final String id = "com.example.healthcare.id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_now);
        TextView t = (TextView)findViewById(R.id.title_buy);
        TextView t1 = (TextView)findViewById(R.id.sub_title);
        TextView t2 = (TextView)findViewById(R.id.price12);
        TextView t3 = (TextView)findViewById(R.id.desc);
        TextView t4 = (TextView)findViewById(R.id.rating);
        Intent intent = getIntent();
        String txt =intent.getStringExtra(Home_Frag.id);
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
        Button buynow = (Button)findViewById(R.id.buynow);
        buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent checkout = new Intent(BuyNow.this,Checkout.class);
                checkout.putExtra(id,txt);
                startActivity(checkout);
            }
        });

    }


}
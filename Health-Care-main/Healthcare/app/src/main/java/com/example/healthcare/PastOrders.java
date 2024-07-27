package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class PastOrders extends AppCompatActivity {
String uid;
String Orderid;
String title;
String qun;
String price11;
String image;
String Address;
String state;
String pin;
String city;
String name;
String phone;
String ORDER_DATE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_orders);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            uid = user.getUid();
//            emails = user.getEmail();
            Orderid = uid+"hcorder";

        }
        else {

        }
        TextView txt = (TextView)findViewById(R.id.title_order);
        txt.setText("Order Not Found");

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(Orderid);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot item : snapshot.getChildren()){
                    if(item.exists()){
                        Map mp = (Map)snapshot.getValue();
                        title = mp.get("title").toString();
                        qun = mp.get("quntity").toString();
                        price11 = mp.get("price").toString();
                        image = mp.get("image").toString();
                        Address = mp.get("address").toString();
                        state = mp.get("state").toString();
                        pin = mp.get("pin").toString();
                        city = mp.get("city").toString();
                        name = mp.get("names").toString();
                        phone = mp.get("phone").toString();
                        ORDER_DATE = mp.get("date").toString();

                        TextView date = (TextView)findViewById(R.id.date);
                        date.setText("Order Placed on: "+ORDER_DATE);

                        TextView oid = (TextView)findViewById(R.id.order_id);
                        oid.setText("Order ID:"+Orderid);

                        TextView tit = (TextView)findViewById(R.id.title_order);
                        tit.setText(title);

                        TextView price = (TextView)findViewById(R.id.price);
                        price.setText(price11);

                        TextView q = (TextView)findViewById(R.id.qun);
                        q.setText("Qty:"+qun);

                        TextView s = (TextView)findViewById(R.id.shipping);
                        s.setText("Shipping Address");

                        TextView na = (TextView)findViewById(R.id.name11);
                        na.setText(name);

                        TextView add = (TextView)findViewById(R.id.add1);
                        add.setText(Address+","+city+","+state+","+pin);

                        TextView p = (TextView)findViewById(R.id.phon);
                        p.setText(phone);






                        String uri = "@drawable/"+image;
                        int imgres = getResources().getIdentifier(uri,null,getPackageName());
                        ImageView im = (ImageView) findViewById(R.id.img);
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

    public void cac(View view){
        String d = ORDER_DATE;
        String sub = d.substring(0,2);
        int dat = Integer.parseInt(sub);
        Date da = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String date = formatter.format(da);
        String sub_date = date.substring(0,2);
        int today = Integer.parseInt(sub_date);
        if(dat == today) {
           cancelorder();
        }
        else {
            Toast.makeText(this, "Order Cancel Only Same day of Order", Toast.LENGTH_SHORT).show();
        }
    }
    public void cancelorder(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query applesQuery = ref.child(Orderid);

        applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                    appleSnapshot.getRef().removeValue();
                    Toast.makeText(PastOrders.this, "Succsess", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("oncancel", "onCancelled", databaseError.toException());
            }
        });
    }


}
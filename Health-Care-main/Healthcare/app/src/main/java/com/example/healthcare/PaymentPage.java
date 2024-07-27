package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import java.util.Calendar;
import java.util.Date;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class PaymentPage extends AppCompatActivity {

    String Tprice,fname,title,quntity,image,Address,pin,state,city,phone,price;
    TextView Show_price;
    EditText promo;
    String getpromo;
    String pro1;
    String pro2;
    String pro3;
    Intent inte;
    String uid;
    String emails;
    String Orderid;
    String date;
    public static final String id = "com.example.healthcare.id";
    private FirebaseFirestore db;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);
        setTitle("Payment Methods");

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("promocodes");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot item : snapshot.getChildren()){
                    if(item.exists()){
                        Map mp = (Map)snapshot.getValue();
                        pro1 = mp.get("promo1").toString();
                        pro2 = mp.get("promo2").toString();
                        pro3 = mp.get("promo3").toString();
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        inte = getIntent();
        fname = inte.getStringExtra(Checkout.fullName);
        title = inte.getStringExtra(Checkout.TITLE);
        quntity = inte.getStringExtra(Checkout.QUNTITY);
        image = inte.getStringExtra(Checkout.IMAGE);
//                Toast.makeText(PaymentPage.this, ""+image, Toast.LENGTH_SHORT).show();
        Address = inte.getStringExtra(Checkout.ADDRESS);
        pin = inte.getStringExtra(Checkout.PIN);
        state = inte.getStringExtra(Checkout.STATE);
        city = inte.getStringExtra(Checkout.CITY);
        phone = inte.getStringExtra(Checkout.PHONE);
        Tprice = inte.getStringExtra(Checkout.FPRICE);
        Show_price = (TextView) findViewById(R.id.total_price);
        promo = (EditText)findViewById(R.id.promo);
        price = inte.getStringExtra(Checkout.FPRICE);
        Show_price.setText(Tprice);

        Date d = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String date = formatter.format(d);

        Button cod= (Button)findViewById(R.id.COD);
        cod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(PaymentPage.this, ""+price, Toast.LENGTH_SHORT).show();
                db = FirebaseFirestore.getInstance();
                Store(fname,title,quntity,image,Address,pin,state,city,phone,price,date);
                SaveToRealTimeDB(fname,title,quntity,image,Address,pin,state,city,phone,price,date);

                cod.setEnabled(false);
////
            }
        });


    }
    public void Store(String fullname,String title,String quntity,String image,String Address,String pin,String state,String city,String phone,String price,String date){
        db = FirebaseFirestore.getInstance();
        CollectionReference dbOrder = db.collection("Orders");
        SaveOrder sv = new SaveOrder(fullname,title,quntity,image,Address,pin,state,city,phone,price,date);
        dbOrder.add(sv).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Intent in = new Intent(PaymentPage.this,ConfirmOrder.class);
                in.putExtra(id,Orderid);
                startActivity(in);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PaymentPage.this, "Something went Wrong \n", Toast.LENGTH_LONG).show();
            }
        });

    }
    public void Apply(View view){
        getpromo = promo.getText().toString();
        String pri =  Tprice.substring(1,4);
        int i_price = Integer.parseInt(pri);
        if(i_price < 400 && getpromo.equals(pro1)){
                int f = i_price - 50;
                String as = Integer.toString(f);
                price = "₹"+as+".00";
            Toast.makeText(this, ""+price, Toast.LENGTH_SHORT).show();
                Show_price.setText("₹"+as+".00");

        }
        else if(i_price > 600 && getpromo.equals(pro2) && i_price < 1000){

                int f = i_price - 100;
                String as = Integer.toString(f);
                price = "₹"+as+".00";
                Show_price.setText("₹" + as + ".00");
        }
        else{
            promo.setError("PromoCode Invalid");
        }
    }

    public void SaveToRealTimeDB(String fullname,String title,String quntity,String image,String Address,String pin,String state,String city,String phone,String price,String date){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            uid = user.getUid();
            emails = user.getEmail();
            Orderid = uid+"hcorder";

        }
        else {

        }

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference(Orderid);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                SaveOrder sv = new SaveOrder(fullname,title,quntity,image,Address,pin,state,city,phone,price,date);
                databaseReference.setValue(sv);
//                Toast.makeText(PaymentPage.this, "SuccessFully RealTimeDB", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(PaymentPage.this, "Check Your Internet Connection", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
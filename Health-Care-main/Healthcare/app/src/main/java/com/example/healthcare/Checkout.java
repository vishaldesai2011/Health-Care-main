package com.example.healthcare;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
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
import com.google.firebase.messaging.FirebaseMessaging;

import org.w3c.dom.Text;

import java.util.Map;

public class Checkout extends AppCompatActivity {
    public static final String fullName = "com.example.healthcare.fullname";
    public static final String EMAIL = "com.example.healthcare.Email";
    public static final String PHONE = "com.example.healthcare.phone";
    public static final String PIN = "com.example.healthcare.pin";
    public static final String CITY = "com.example.healthcare.city";
    public static final String STATE = "com.example.healthcare.state";
    public static final String ADDRESS = "com.example.healthcare.address";
    public static final String FPRICE = "com.example.healthcare.fprice";
    public static final String QUNTITY = "com.example.healthcare.quntity";
    public static final String TITLE = "com.example.healthcare.title";
    public static final String IMAGE = "com.example.healthcare.IMAGE";
    TextView qun;
    String QUN;
    int num;
    String uid;
    String emails;
    String price,title,image;
    FirebaseFirestore db;
    Button buy_now;
    String tp;
    String fprice;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        EditText email = (EditText) findViewById(R.id.email1);
        EditText fname = (EditText) findViewById(R.id.fname);
        EditText lname = (EditText) findViewById(R.id.lname);
        EditText contact = (EditText) findViewById(R.id.phone);
        EditText pin = (EditText) findViewById(R.id.pin);
        EditText city = (EditText) findViewById(R.id.city);
        EditText state = (EditText)findViewById(R.id.state);
        EditText Address = (EditText)findViewById(R.id.add);
        TextView tit = (TextView)findViewById(R.id.title1);
        TextView price_t = (TextView)findViewById(R.id.price12);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        buy_now = (Button)findViewById(R.id.btn_buynow);
        if (user != null) {
            // User is signed in
            uid = user.getUid();
            emails = user.getEmail();
        }
        else {

        }
        Intent intent = getIntent();
        String pid = intent.getStringExtra(BuyNow.id);
        DatabaseReference ref1 = FirebaseDatabase.getInstance().getReference().child(pid);
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot item : snapshot.getChildren()){
                    if(item.exists()){
                        Map mp1 = (Map)snapshot.getValue();
                        price = mp1.get("price").toString();
                        title = mp1.get("title").toString();
                        image = mp1.get("image").toString();
                        tit.setText(title);
                        String p2 = price.substring(1,4);
                        tp = p2;
                        buy_now.setText("Pay Now "+"("+price+")");
                        price_t.setText(price);
                        String uri = "@drawable/"+image;
                        int img = getResources().getIdentifier(uri,null,getPackageName());
                        ImageView im = (ImageView)findViewById(R.id.pro_img);
                        Drawable res = getResources().getDrawable(img);
                        im.setImageDrawable(res);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        email.setText(emails);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(uid);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot item : snapshot.getChildren()){
                    if(item.exists()){
                        Map mp = (Map)snapshot.getValue();
                        fname.setText(mp.get("firstName").toString());
                        lname.setText(mp.get("lastName").toString());
                        contact.setText(mp.get("contact").toString());
                        Log.d("snap",""+snapshot.getValue().toString());


                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("snap","fail!!!");
            }
        });
//First Name Focus
        fname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if(focus) {
                    fname.setBackgroundResource(R.drawable.border_login);
                }
               else {
                    fname.setBackgroundResource(R.drawable.borderview_4);
                }
            }
        });
//Last Name Focus
        lname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if(focus) {
                    lname.setBackgroundResource(R.drawable.border_login);
                }
                else {
                    lname.setBackgroundResource(R.drawable.borderview_4);
                }
            }
        });

//Email Focus
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if(focus) {
                    email.setBackgroundResource(R.drawable.border_login);
                }
                else {
                    email.setBackgroundResource(R.drawable.borderview_4);
                }
            }
        });
//Contact Focus
        contact.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if(focus) {
                    contact.setBackgroundResource(R.drawable.border_login);
                }
                else {
                    contact.setBackgroundResource(R.drawable.borderview_4);
                }
            }
        });
//PinCode Focus
        pin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if(focus) {
                    pin.setBackgroundResource(R.drawable.border_login);
                }
                else {
                    pin.setBackgroundResource(R.drawable.borderview_4);
                }
            }
        });
//City Focus
        city.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if(focus) {
                    city.setBackgroundResource(R.drawable.border_login);
                }
                else {
                    city.setBackgroundResource(R.drawable.borderview_4);
                }
            }
        });
//State Focus
        state.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if(focus) {
                    state.setBackgroundResource(R.drawable.border_login);
                }
                else {
                    state.setBackgroundResource(R.drawable.borderview_4);
                }
            }
        });
//Address Focus
        Address.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if(focus) {
                    Address.setBackgroundResource(R.drawable.border_login);
                }
                else {
                    Address.setBackgroundResource(R.drawable.borderview_4);
                }
            }
        });
// Get FMC token
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
            if(!task.isSuccessful()){
                System.out.print("Fetching FMC registration Token ");
                return;

            }


                String token = task.getResult();
            Log.d("token","FMC"+token);
//                Toast.makeText(Checkout.this, ""+token, Toast.LENGTH_SHORT).show();
            }
        });

        s = "1";
    }






    public void plush(View view){

        qun = (TextView)findViewById(R.id.quntity);
        QUN = qun.getText().toString();
        num=Integer.parseInt(QUN);
        String p1 = price.substring(1,4);
        int price = Integer.parseInt(p1);
        if(num <= 10) {
            int Ans = num + 1;
            int Total_price = price * Ans;
            tp = Integer.toString(Total_price);
            s = Integer.toString(Ans);
            qun.setText(s);
            buy_now = (Button)findViewById(R.id.btn_buynow);
            buy_now.setText("Pay Now "+"(₹"+tp+".00)");
            fprice = "₹"+tp+".00";
        }
        else if(num >= 10){
            qun.setText("10");
            Toast.makeText(this, "Maximum 10 Quntity ", Toast.LENGTH_SHORT).show();
        }

    }
//    Quntity -
    public void minush(View view){
        qun = (TextView)findViewById(R.id.quntity);
        QUN = qun.getText().toString();
        String p1 = price.substring(1,4);
        int price = Integer.parseInt(p1);
//        Toast.makeText(this, ""+p1, Toast.LENGTH_SHORT).show();
        num = Integer.parseInt(QUN);
        if(num != 1) {
            int Ans = num - 1;
            int Total_price = price * Ans;
            tp = Integer.toString(Total_price);
            s = Integer.toString(Ans);
            qun.setText(s);
            buy_now = (Button)findViewById(R.id.btn_buynow);
            buy_now.setText("Pay Now "+"(₹"+tp+".00)");
            fprice = "₹"+tp+".00";

        }
        else if(num == 1) {
            Toast.makeText(this, "Please Enter Valid Quntity", Toast.LENGTH_SHORT).show();
        }

    }
    public void paynow(View view){
        Intent Inte = new Intent(Checkout.this,PaymentPage.class);
        EditText fn = (EditText)findViewById(R.id.fname);
        EditText ln = (EditText)findViewById(R.id.lname);
        EditText contact = (EditText) findViewById(R.id.phone);
        EditText pin = (EditText) findViewById(R.id.pin);
        EditText city = (EditText) findViewById(R.id.city);
        EditText state = (EditText)findViewById(R.id.state);
        EditText Address = (EditText)findViewById(R.id.add);
        EditText email = (EditText) findViewById(R.id.email1);
        int con = contact.length();
        int p_l = pin.length();
        if(Address.getText().toString().isEmpty()){
            Address.setError("Address is Required !!");

        }
        else if(fn.getText().toString().isEmpty()){
            fn.setError("First Name is Required !!");

        }
        else if(ln.getText().toString().isEmpty()){
            ln.setError("Last Name is  Required !!");

        }
        else if(contact.getText().toString().isEmpty()){
            contact.setError("Contact is Required !!");

        }
        else if(con !=10){
            contact.setError("Contact invalid !!");

        }

        else if(pin.getText().toString().isEmpty()){
            pin.setError("Pin is invalid !!");

        }
        else if(p_l != 6){
            pin.setError("Pin is Required !!");

        }
        else if(state.getText().toString().isEmpty()){
            state.setError("State Required !!");

        }
        else if(city.getText().toString().isEmpty()){
            city.setError("State Required !!");

        }
        else if(email.getText().toString().isEmpty()){
            email.setError("Email Required !!");

        }
        else {
            Inte.putExtra(fullName, "" + fn.getText().toString() + " " + ln.getText().toString());
            Inte.putExtra(EMAIL, "" + email.getText().toString());
            Inte.putExtra(PHONE, "" + contact.getText().toString());
            Inte.putExtra(PIN, "" + pin.getText().toString());
            Inte.putExtra(CITY, "" + city.getText().toString());
            Inte.putExtra(STATE, "" + state.getText().toString());
            Inte.putExtra(ADDRESS, "" + Address.getText().toString());
            Inte.putExtra(FPRICE, "" + "₹" + tp + ".00");
            Inte.putExtra(QUNTITY, "" + s);
            Inte.putExtra(TITLE, title);
            Inte.putExtra(IMAGE, image);
            startActivity(Inte);
        }
    }
    public void order(View view){
        db = FirebaseFirestore.getInstance();
        StoreToFireStore("admin","Patel");
    }
    private void StoreToFireStore(String fname,String lname){
//        CollectionReference dborder = db.collection("Orders");
//        SaveOrder orders = new SaveOrder(fname, lname);
//        dborder.add(orders).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//            @Override
//            public void onSuccess(DocumentReference documentReference) {
//                Toast.makeText(Checkout.this, "Your Order has been PlacedSuccessfully", Toast.LENGTH_SHORT).show();
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(Checkout.this, "Something Wrong", Toast.LENGTH_SHORT).show();
//            }
//        });


    }



}
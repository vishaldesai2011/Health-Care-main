package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateProfile extends AppCompatActivity {
    EditText fname,lname,contact,Ages;
    String uid,emails;
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            uid = user.getUid();
            emails = user.getEmail();
            Log.d("uid",""+uid);

            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
                @Override
                public void onComplete(@NonNull Task<String> task) {
                    if(!task.isSuccessful()){
                        System.out.print("Fetching FMC registration Token ");
                        return;

                    }
                    token = task.getResult();
                    Log.d("token","FMC"+token);
//                Toast.makeText(UpdateProfile.this, ""+token, Toast.LENGTH_SHORT).show();
                }
            });

        } else {

        }



    }
    public void SAVE(View view){

        fname =findViewById(R.id.firstname);
        lname=findViewById(R.id.lastname);
        contact=findViewById(R.id.contact);
        Ages = findViewById(R.id.age);

        String Fname = fname.getText().toString();
        String Lname = lname.getText().toString();
        String Contact = contact.getText().toString();
        String age = Ages.getText().toString();

        Pattern ps = Pattern.compile("^[a-zA-Z ]+$");
        Matcher ms = ps.matcher(Fname);
        Matcher ms1 = ps.matcher(Lname);
        boolean bs = ms.matches();
        boolean bs1 = ms1.matches();
        if(Fname.length() <= 3 || bs == false){
            fname.setError("Plese Enter Valid FirstName");
        }
        else if(Lname.length() <= 3 || bs1 == false){
            lname.setError("Plese Enter Valid LastName");
        }
        else if(Contact.length() <= 9 || Contact.length() > 10){
            contact.setError("Plese Enter Valid Contact");
        }
        else if(age.length() == 0 || age.length() > 3){
            Ages.setError("Plese Enter Valid Age");
        }
        else {
            Log.d("VALID", "Hey I Am hear");

            UserData ud = new UserData();
            ud.setUID(uid);
            ud.setFCM(token);
            ud.setFirstName(Fname);
            ud.setLastName(Lname);
            ud.setContact(Contact);
            ud.setEmail(emails);
            ud.setAge(age);

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference(uid);
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    databaseReference.setValue(ud);
                    Toast.makeText(UpdateProfile.this, "Your Profile Data SuccessFully Updated", Toast.LENGTH_SHORT).show();
                    Button btn = (Button) findViewById(R.id.save);
                    btn.setEnabled(false);
                    startActivity(new Intent(UpdateProfile.this, MainActivity.class));
                    finish();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(UpdateProfile.this, "Fail To Update" + error, Toast.LENGTH_SHORT).show();
                }

            });
        }




    }
}
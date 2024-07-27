package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class PastAppointment extends AppCompatActivity {
    String Name;
    String Spec;
    String Dr_Name;
    String HOS;
    String con;
    String date;
    String uid;
    String ap_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_appointment);
        setTitle("Appointment");
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            uid = user.getUid();
//            emails = user.getEmail();
            ap_id = uid+"hcappoi";

        }
        else {

        }
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(ap_id);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot item : snapshot.getChildren()) {
                    if (item.exists()) {
                        Map mp = (Map) snapshot.getValue();
                        Name = mp.get("patientName").toString();
                        date = mp.get("date").toString();
                        HOS = mp.get("hospital").toString();
                        Dr_Name = mp.get("doctor").toString();
                        Spec = mp.get("speciality").toString();
                        con = mp.get("phone").toString();
                        TextView name = (TextView)findViewById(R.id.name_ap);
                        name.setText(Name);
                        TextView DATE = (TextView)findViewById(R.id.date_ap);
                        DATE.setText(date);
                        TextView hos = (TextView)findViewById(R.id.hos_ap);
                        hos.setText(HOS);
                        TextView dr = (TextView)findViewById(R.id.dr_ap);
                        dr.setText(Dr_Name);
                        TextView sp = (TextView)findViewById(R.id.spe_ap);
                        sp.setText(Spec);
                        TextView c = (TextView)findViewById(R.id.con_ap);
                        c.setText(con);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
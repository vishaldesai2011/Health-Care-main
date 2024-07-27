package com.example.healthcare;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyAccount#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyAccount extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String emails;
    String uid;
    String Fullname;
    final List<String> mArray = new ArrayList<>();

    public MyAccount() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyAccount.
     */
    // TODO: Rename and change types and number of parameters
    public static MyAccount newInstance(String param1, String param2) {
        MyAccount fragment = new MyAccount();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my_account, container, false);


//        ImageView image = (ImageView)view.findViewById(R.id.);
        TextView fname = (TextView)view.findViewById(R.id.firstname);
        TextView lname = (TextView)view.findViewById(R.id.lastname);
        TextView con = (TextView)view.findViewById(R.id.contact);
        TextView email = (TextView)view.findViewById(R.id.email_data);
        TextView txt = (TextView)view.findViewById(R.id.hello);
        TextView AGE = (TextView)view.findViewById(R.id.agee);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            uid = user.getUid();
            emails = user.getEmail();
        }
        else {

        }
//        fname.setText("-");
        lname.setText("");
        con.setText("");
        email.setText(emails);

        Button up = (Button)view.findViewById(R.id.save);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent inte = new Intent(getActivity(),UpdateProfile.class);
            startActivity(inte);
            }
        });
// Data Retrieve From RealTime
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(uid);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot item : snapshot.getChildren()){
                    if(item.exists()){
                        Map mp = (Map)snapshot.getValue();
                        fname.setText(mp.get("firstName").toString());
                        lname.setText(mp.get("lastName").toString());
                        con.setText(mp.get("contact").toString());
                        AGE.setText(mp.get("age").toString());
                        txt.setText("Hello, "+mp.get("firstName").toString()+" "+mp.get("lastName").toString());
                        Log.d("snap",""+snapshot.getValue().toString());

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("snap","fail!!!");
            }
        });
        Button logout = (Button)view.findViewById(R.id.delete);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                ProgressDialog progressBar = new ProgressDialog(getActivity());
                progressBar.setMessage("Logout...");
                progressBar.show();
                SystemClock.sleep(4000);
                Intent inte = new Intent(getActivity(),LoginActivity.class);
                startActivity(inte);
            }
        });


//        https://www.geeksforgeeks.org/how-to-delete-data-from-firebase-realtime-database-in-android/
        return view;
    }
}
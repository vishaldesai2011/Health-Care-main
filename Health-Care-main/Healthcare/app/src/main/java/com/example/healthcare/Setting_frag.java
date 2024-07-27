package com.example.healthcare;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
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

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Setting_frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Setting_frag extends Fragment {
    String[] Hospital = {"Select Hospital", "Ahmedabad", "Vadodara", "Delhi", "Mumbai", "Bangalore"};
    String[] Speciality = {"Select Speciality", "Cardiologists", "General-medicine", "General-surgeons", "Orthopedic", "Radiologists"};
    String[] Doctor = {"Select Doctor", "Dr William A. Abdu, M.D, M.S.", "Dr Myles. B. Abbott, M.D.", "Dr Naresh Trehan", "Dr Arthur Reese Abright, M.D.","Dr Mona. M. Abaza, M.D"};
    String Hospital_Name;
    String Doctor_Speciality;
    String Doc;
    int year;
    int month;
    int day;
    String T;
    String uid;
    String emails;
    String Aid;
    String patient;
    String phon;
    EditText p;
    EditText phone;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Setting_frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Setting_frag.
     */
    // TODO: Rename and change types and number of parameters
    public static Setting_frag newInstance(String param1, String param2) {
        Setting_frag fragment = new Setting_frag();
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
        View view=  inflater.inflate(R.layout.fragment_setting_frag, container, false);
        p = (EditText)view.findViewById(R.id.pat);
        phone = (EditText)view.findViewById(R.id.pnumber);

        Spinner spin1 = (Spinner)view.findViewById(R.id.spin1);
        ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,Hospital);
        spin1.setAdapter(aa);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(Hospital[i] == "Select Hospital"){

                }
                else {
                    Toast.makeText(getActivity(),Hospital[i] , Toast.LENGTH_LONG).show();
                    Hospital_Name = Hospital[i];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Spinner spin3 = (Spinner)view.findViewById(R.id.spinner3);
        ArrayAdapter aa1 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,Speciality);
        spin3.setAdapter(aa1);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(Speciality[i] == "Select Speciality"){

                }
                else {
                    Toast.makeText(getActivity(),Speciality[i] , Toast.LENGTH_LONG).show();
                    Doctor_Speciality = Speciality[i];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner spin4 = (Spinner)view.findViewById(R.id.spinner4);
        ArrayAdapter aa2 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,Doctor);
        spin4.setAdapter(aa2);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(Doctor[i] == "Select Doctor"){

                }
                else {
                    Toast.makeText(getActivity(),Doctor[i] , Toast.LENGTH_LONG).show();
                    Doc = Doctor[i];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

            TextView da = (TextView) view.findViewById(R.id.dp);
            Calendar calendar = Calendar.getInstance();
            da.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH);
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {


                            if(day > dayOfMonth || month > monthOfYear){
                                da.setError("Date Not Valid !!");

                            }
                            else {
                                da.setError(null);
                                da.setText("" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                Toast.makeText(getActivity(), "" + dayOfMonth, Toast.LENGTH_SHORT).show();
                                T = "" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                                Toast.makeText(getActivity(), "" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year, Toast.LENGTH_SHORT).show();
//                            Toast.makeText(getActivity(), ""+T, Toast.LENGTH_SHORT).show();
                            }
                        }
                    },year,month,day);
                    datePickerDialog.show();
                }
            });

            Button about = (Button)view.findViewById(R.id.abouthos);
            about.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent inte = new Intent(getActivity(),AboutHospital.class);
                    startActivity(inte);
                }
            });
        Button book = (Button)view.findViewById(R.id.bookApp);
        book.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                patient = p.getText().toString();
                phon = phone.getText().toString();
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    // User is signed in
                    uid = user.getUid();
                    emails = user.getEmail();
                    Aid = uid+"hcappoi";

                }
                else {

                }
                StroreDB(patient,Hospital_Name,Doctor_Speciality,Doc,T,phon);
                SaveAppoinment sv = new SaveAppoinment(patient,Hospital_Name,Doctor_Speciality,Doc,T,phon);
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = firebaseDatabase.getReference(Aid);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                     databaseReference.setValue(sv);
                        Toast.makeText(getActivity(), "Your Appointment Succseefully Booked", Toast.LENGTH_SHORT).show();
                        Intent inte  = new Intent(getActivity(),PastAppointment.class);
                        startActivity(inte);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Fail To Book An Appoinment", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        Button Appoinment_Check = (Button)view.findViewById(R.id.Appoinment_Check);
        Appoinment_Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent appoi = new Intent(getActivity(),PastAppointment.class);
                startActivity(appoi);
            }
        });
        return view;
    }
    public void  StroreDB(String patient,String Hospital_Name,String Doctor_Speciality,String Doc,String T,String phon){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        SaveAppoinment sv = new SaveAppoinment(patient,Hospital_Name,Doctor_Speciality,Doc,T,phon);
        CollectionReference dbAppoi = db.collection("Appointment");
        dbAppoi.add(sv).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getActivity(), "SuccessFully in FireStore", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "SuccessFully to Store FireStore", Toast.LENGTH_SHORT).show();
            }
        });






    }

}
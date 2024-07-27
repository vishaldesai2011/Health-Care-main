package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Order_Frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Order_Frag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Order_Frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Order_Frag.
     */
    // TODO: Rename and change types and number of parameters
    public static Order_Frag newInstance(String param1, String param2) {
        Order_Frag fragment = new Order_Frag();
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
        View view = inflater.inflate(R.layout.fragment_order_, container, false);
        final ListView list = view.findViewById(R.id.list);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("All");
        arrayList.add("Covid Protection");
        arrayList.add("Diabetes Care");
        arrayList.add("Pain Relief");
        arrayList.add("Ayurveda");
        arrayList.add("Face");
        arrayList.add("Hair");
//        arrayList.add("Beauty");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, arrayList);list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem=(String) list.getItemAtPosition(position);
                if(clickedItem == "Covid Protection") {
                    Intent in = new Intent(getActivity(), CovidProtection.class);
                    startActivity(in);
                }
                else if(clickedItem == "Diabetes Care"){
                    Intent in = new Intent(getActivity(), DiabetesCare.class);
                    startActivity(in);
                }

                else if(clickedItem == "Pain Relief"){
                    Intent in = new Intent(getActivity(), PainRelief.class);
                    startActivity(in);
                }

                else if(clickedItem == "Ayurveda"){
                    Intent in = new Intent(getActivity(), Ayurveda.class);
                    startActivity(in);
                }
                else if(clickedItem == "Face"){
                    Intent in = new Intent(getActivity(), Face.class);
                    startActivity(in);
                }
                else if(clickedItem == "Hair"){
                    Intent in1 = new Intent(getActivity(), Hair.class);
                    startActivity(in1);
                }
                else if(clickedItem == "All"){
                    Intent in1 = new Intent(getActivity(), AllProducts.class);
                    startActivity(in1);
                }
                else {
                    Toast.makeText(getActivity(), clickedItem, Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }

}
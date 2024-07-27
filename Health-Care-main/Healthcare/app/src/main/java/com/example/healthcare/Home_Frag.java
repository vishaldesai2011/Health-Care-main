package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home_Frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home_Frag extends Fragment {
    public static final String id = "com.example.healthcare.id";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Home_Frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home_Frag.
     */
    // TODO: Rename and change types and number of parameters
    public static Home_Frag newInstance(String param1, String param2) {
        Home_Frag fragment = new Home_Frag();
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
        View view =  inflater.inflate(R.layout.fragment_home_, container, false);
//        TextView txt = (TextView) view.findViewById(R.id.ids);
//        txt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "Body 1", Toast.LENGTH_SHORT).show();
//            }
//        });
        Button btn = (Button)view.findViewById(R.id.disprin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(getActivity(),BuyNow.class);
                inte.putExtra(id,"OnionOil");
                startActivity(inte);
            }
        });
        Button btn1 = (Button)view.findViewById(R.id.gal);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(getActivity(),BuyNow.class);
                inte.putExtra(id,"UbtanFaceWash");
                startActivity(inte);
            }
        });
        Button btn2 = (Button)view.findViewById(R.id.zandu);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(getActivity(),BuyNow.class);
                inte.putExtra(id,"CFacewash");
                startActivity(inte);
            }
        });

        Button btn3 = (Button)view.findViewById(R.id.painout);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(getActivity(),BuyNow.class);
                inte.putExtra(id,"CToner");
                startActivity(inte);
            }
        });

        Button btn4 = (Button)view.findViewById(R.id.chav);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(getActivity(),BuyNow.class);
                inte.putExtra(id,"teatree");
                startActivity(inte);
            }
        });

        Button btn5 = (Button)view.findViewById(R.id.tulsidrop);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(getActivity(),BuyNow.class);
                inte.putExtra(id,"ubtonscrub");
                startActivity(inte);
            }
        });
        TextView face = (TextView)view.findViewById(R.id.face);
        face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte1 = new Intent(getActivity(),Face.class);
                startActivity(inte1);
            }
        });

        TextView Hair = (TextView)view.findViewById(R.id.Hair);
        Hair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte2 = new Intent(getActivity(),Hair.class);
                startActivity(inte2);
            }
        });

        TextView pai = (TextView)view.findViewById(R.id.pain);
        pai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte3 = new Intent(getActivity(),PainRelief.class);
                startActivity(inte3);
            }
        });

        TextView cov = (TextView)view.findViewById(R.id.covi);
        cov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte4= new Intent(getActivity(),CovidProtection.class);
                startActivity(inte4);
            }
        });

        return view;
    }



}
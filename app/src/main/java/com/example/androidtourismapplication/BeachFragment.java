package com.example.androidtourismapplication;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BeachFragment extends Fragment {


    View view;



    public BeachFragment() {

    }

    private static final String TAG = "BeachFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beach, container, false);

        LinearLayout btn = (LinearLayout) view.findViewById(R.id.lay1);
        LinearLayout btn2 = (LinearLayout) view.findViewById(R.id.lay2);
        LinearLayout btn3 = (LinearLayout) view.findViewById(R.id.lay3);
        LinearLayout btn4 = (LinearLayout) view.findViewById(R.id.lay4);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), cullen.class);
                startActivity(intent);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), sbb.class);
                startActivity(intent);
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), wsb.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), lusk.class);
                startActivity(intent);
            }
        });




        return view;
    }















//
//
//    public void onCreate(@Nullable Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//
//        ourDataList = new ArrayList<>();
//        ourDataList.add(new OurData("Cullen Beach", R.drawable.cullen));
//        ourDataList.add(new OurData("Luskentyre Beach", R.drawable.luskentyre));
//        ourDataList.add(new OurData("Sandwood Bay Beach", R.drawable.sandwoodbb));
//        ourDataList.add(new OurData("WestSands Beach", R.drawable.westsands));
//    }

    }

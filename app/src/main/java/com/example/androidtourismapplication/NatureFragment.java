package com.example.androidtourismapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NatureFragment extends Fragment {


    View v;
//    private  RecyclerView myrecyclerview;
//    private List<OurData> ourDataList;
//
//    public NatureFragment() {
//
//    }

    private static final String TAG = "NatureFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nature, container, false);

        LinearLayout btn = (LinearLayout) view.findViewById(R.id.lay9);
        LinearLayout btn2 = (LinearLayout) view.findViewById(R.id.lay10);
        LinearLayout btn3 = (LinearLayout) view.findViewById(R.id.lay11);
        LinearLayout btn4 = (LinearLayout) view.findViewById(R.id.lay12);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), strath.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), smoo.class);
                startActivity(intent);
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loch.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ben.class);
                startActivity(intent);
            }
        });




        return view;

    }
}


//    public void onCreate(@Nullable Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//
//        ourDataList = new ArrayList<>();
//        ourDataList.add(new OurData("Ben Nevis", R.drawable.bennevis));
//        ourDataList.add(new OurData("loch Ness", R.drawable.lochness));
//        ourDataList.add(new OurData("Smoo Cave", R.drawable.smoo));
//        ourDataList.add(new OurData("Strathclyde Park", R.drawable.strathclyde));
//    }


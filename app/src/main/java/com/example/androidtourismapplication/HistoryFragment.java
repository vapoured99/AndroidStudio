package com.example.androidtourismapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {


    View v;
//    private RecyclerView myrecyclerview;
//    private List<OurData> ourDataList;

//    public HistoryFragment() {
//
//    }

    private static final String TAG = "HistoryFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);


        Button btn = (Button)view.findViewById(R.id.button1);
        Button btn2 = (Button)view.findViewById(R.id.button2);
        Button btn3 = (Button)view.findViewById(R.id.button3);
        Button btn4 = (Button)view.findViewById(R.id.button4);
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
}



//        myrecyclerview = (RecyclerView) v.findViewById(R.id.recycler_view);
//        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(),ourDataList);
//        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
//        myrecyclerview.setAdapter(recyclerAdapter);
//        return v;
//
//    }
//
//
//
//    public void onCreate(@Nullable Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//
//        ourDataList = new ArrayList<>();
//        ourDataList.add(new OurData("Wallace Monument", R.drawable.wallace));
//        ourDataList.add(new OurData("Prince Albert's Pyramid", R.drawable.pap));
//        ourDataList.add(new OurData("Linlithgow Castle", R.drawable.lin));
//        ourDataList.add(new OurData("Dunnottar Castle", R.drawable.dunnottar));
//    }
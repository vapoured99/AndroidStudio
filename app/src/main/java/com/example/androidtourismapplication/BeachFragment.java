package com.example.androidtourismapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BeachFragment extends Fragment {


    View v;
    private  RecyclerView myrecyclerview;
    private List<OurData> ourDataList;

    public BeachFragment() {

    }

    private static final String TAG = "BeachFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_beach, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(),ourDataList);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;

    }



    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        ourDataList = new ArrayList<>();
        ourDataList.add(new OurData("Cullen Beach", R.drawable.cullen));
        ourDataList.add(new OurData("Luskentyre Beach", R.drawable.luskentyre));
        ourDataList.add(new OurData("Sandwood Bay Beach", R.drawable.sandwoodbb));
        ourDataList.add(new OurData("WestSands Beach", R.drawable.westsands));
    }

}
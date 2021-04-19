package com.example.androidtourismapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.security.AccessController;

public class HomeFragment extends AppCompatActivity {


    GridLayout gridL;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        gridL = (GridLayout)findViewById(R.id.gridL);

        setSingleEvent(gridL);


    }


    private void setSingleEvent(GridLayout gridL){
        for (int i =0; i<gridL.getChildCount(); i++) {

            CardView cardView = (CardView)gridL.getChildAt(i);
            final int finalI = i;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (finalI ==0){
                        Intent intent = new Intent(HomeFragment.this, wallace.class);
                        startActivity(intent);
                    }
                    else  if (finalI ==1){
                        Intent intent = new Intent(HomeFragment.this, sbb.class);
                        startActivity(intent);
                    }
                    else if (finalI ==2){
                        Intent intent = new Intent(HomeFragment.this, smoo.class);
                        startActivity(intent);
                    }
                    else if (finalI ==3){
                        Intent intent = new Intent(HomeFragment.this, ben.class);
                        startActivity(intent);
                    }
                    else if (finalI ==4){
                        Intent intent = new Intent(HomeFragment.this, dun.class);
                        startActivity(intent);
                    }
                    else if (finalI ==5){
                        Intent intent = new Intent(HomeFragment.this, lusk.class);
                        startActivity(intent);
                    }
                    else if (finalI ==6){
                        Intent intent = new Intent(HomeFragment.this, pap.class);
                        startActivity(intent);
                    }
                    else if (finalI ==7){
                        Intent intent = new Intent(HomeFragment.this, cullen.class);
                        startActivity(intent);
                    }
                    else if (finalI ==8){
                        Intent intent = new Intent(HomeFragment.this, loch.class);
                        startActivity(intent);
                    }
                    else if (finalI ==9){
                        Intent intent = new Intent(HomeFragment.this, strath.class);
                        startActivity(intent);
                    }
                    else if (finalI ==10){
                        Intent intent = new Intent(HomeFragment.this, wsb.class);
                        startActivity(intent);
                    }
                    else if (finalI ==11){
                        Intent intent = new Intent(HomeFragment.this, lin.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(HomeFragment.this, "please set an activity for this card", Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }

}
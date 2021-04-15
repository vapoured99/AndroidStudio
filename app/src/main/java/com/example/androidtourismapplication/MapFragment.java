package com.example.androidtourismapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
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

public class MapFragment extends Fragment  implements OnMapReadyCallback{


    GoogleMap mgoogleMap;
    MapView mapView;
    View mView;




    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        mView = inflater.inflate(R.layout.fragment_map, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        mapView = (MapView) mView.findViewById(R.id.mapview);
        if (mapView != null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());

        mgoogleMap = googleMap;
//        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.bennevis);

        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        googleMap.addMarker(new MarkerOptions().position(new LatLng(56.79685711,-5.00355049999996)).title("Ben Nevis").snippet("Scotlands Highest Mountain!"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(57.692725,-2.823514)).title("Cullen Beach").snippet("An amazing beach!"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(56.945777,-2.19719)).title("Dunnotar Castle").snippet("Stunning Castle!"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(55.977615,-3.600869)).title("Linlithgow").snippet("A lesson in history!"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(57.322858,-4.424382)).title("Loch Ness").snippet("Scotland's famous monster!"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(57.891393,-6.951448)).title("Luskentyre Beach").snippet("The most beautiful beach!"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(57.01338,-3.13166)).title("Prince Albert's Pyramid").snippet("Scotland's famous pyramid's"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(58.538392,-5.059977)).title("Sandwood Bay Beach").snippet("Gorgeous beach!"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(58.563062,-4.719952)).title("Smoo Cave").snippet("Scotland's hidden caves!"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(55.785288,-4.014812)).title("Strathclyde country park").snippet("A great day out!"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(56.13878,-3.9178948)).title("Wallace Monument").snippet("Famous war monument!"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(56.3555621,-2.808676)).title("West Sands Beach").snippet("Great for a sunny day!"));

        CameraPosition Scotland = CameraPosition.builder().target(new LatLng(56.6194291,-3.8660564)).zoom(7).bearing(0).tilt(45).build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Scotland));

    }
}


package com.example.androidtourismapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    // GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener

    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_map);
        mapFragment.getMapAsync(this);

        client = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getCurrentLocation();
        } else {
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }


    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {

                    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

                            MarkerOptions options = new MarkerOptions().position(latLng).title("I am there");

                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 7));

                            googleMap.addMarker(options);
                        }
                    });
                }
            }
        });
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 44){
            if (grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                getCurrentLocation();
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng location = new LatLng(57.36416,-2.0728);
        MarkerOptions  options = new MarkerOptions();
        options.position(location);
        options.title("YOU");
        options.snippet("This is your location");
        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));



        googleMap.addMarker(new MarkerOptions().position(new LatLng(56.79685711,-5.00355049999996)).title("Ben Nevis").snippet("Scotlands Highest Mountain!").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_mountain32)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(57.692725,-2.823514)).title("Cullen Beach").snippet("An amazing beach!").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_beach32)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(56.945777,-2.19719)).title("Dunnotar Castle").snippet("Stunning Castle!").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_castle32)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(55.977615,-3.600869)).title("Linlithgow").snippet("A lesson in history!").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_castle32)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(57.322858,-4.424382)).title("Loch Ness").snippet("Scotland's famous monster!").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_loch32)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(57.891393,-6.951448)).title("Luskentyre Beach").snippet("The most beautiful beach!").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_beach32)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(57.01338,-3.13166)).title("Prince Albert's Pyramid").snippet("Scotland's famous pyramid's").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_pyramid32)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(58.538392,-5.059977)).title("Sandwood Bay Beach").snippet("Gorgeous beach!").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_beach32)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(58.563062,-4.719952)).title("Smoo Cave").snippet("Scotland's hidden caves!").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_cave32)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(55.785288,-4.014812)).title("Strathclyde country park").snippet("A great day out!").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_nature32)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(56.13878,-3.9178948)).title("Wallace Monument").snippet("Famous war monument!").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_mon32)));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(56.3555621,-2.808676)).title("West Sands Beach").snippet("Great for a sunny day!").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_beach32)));

        CameraPosition Scotland = CameraPosition.builder().target(new LatLng(56.6194291,-3.8660564)).zoom(7).bearing(0).tilt(90).build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Scotland));

        googleMap.addMarker(options);

//        googleMap.setOnMarkerClickListener(this);
//        googleMap.setOnMarkerDragListener(this);
    }


//    @Override
//    public boolean onMarkerClick(Marker marker) {
//        Log.d("MapsActivity", marker.getTitle());
//        return true;
//    }
//
//
//
//    @Override
//    public void onMarkerDrag(Marker marker) {
//        Log.d("MapsActivity", marker.getPosition().toString());
//    }
//
//    @Override
//    public void onMarkerDragEnd(Marker marker) {
//
//    }
//
//    @Override
//    public void onMarkerDragStart(Marker marker) {
//
//    }
}

package com.example.androidtourismapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

//public class Settings extends Fragment {
//
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
//        return inflater.inflate(R.layout.settings, container, false);
//    }
//
//
//
//}


public class Settings extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    Switch nightMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.DarkTheme);
        }else{
            setTheme(R.style.LightTheme);
        }

        super.onCreate(savedInstanceState);


        setContentView(R.layout.settings);

        nightMode = findViewById(R.id.nightmode);
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            nightMode.setChecked(true);
        }

       nightMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked){
                   AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                   restartActivity();
               }else{
                   AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
               }
           }


       });



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Settings");



        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_home:
                Intent intentH = new Intent(this, MainActivity.class);
                this.startActivity(intentH);
                break;


            case R.id.nav_fav:
                Intent intentF = new Intent(this, FavouritesFragment.class);
                this.startActivity(intentF);
                break;


            case R.id.nav_map:
                Intent intentM = new Intent(this, MapFragment.class);
                this.startActivity(intentM);
                break;


            case R.id.nav_info:
                Intent intentI = new Intent(this, Info.class);
                this.startActivity(intentI);
                break;




            case R.id.nav_cat:
                Intent intentC = new Intent(this, ContentMain.class);
                this.startActivity(intentC);
                break;

            case R.id.nav_settings:
                Intent intentS = new Intent(this, Settings.class);
                this.startActivity(intentS);
                break;

            case R.id.nav_login:
                Intent intent = new Intent(this, login.class);
                this.startActivity(intent);
                break;

            case R.id.nav_logout:
                Intent intent2 = new Intent(this, login.class);
                this.startActivity(intent2);
                break;

            case R.id.nav_signup:
                Intent intent3 = new Intent(this, signup.class);
                this.startActivity(intent3);
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void logout (MenuItem item){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), login.class));
        finish();
    }

    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    private void restartActivity() {
        Intent i = new Intent(getApplicationContext(), Settings.class);
        startActivity(i);
        finish();
    }


}
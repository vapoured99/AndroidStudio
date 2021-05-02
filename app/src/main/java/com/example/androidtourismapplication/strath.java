package com.example.androidtourismapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class strath extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawer;
    AlertDialog alertDialog1;
    Switch font;
    TextView textView;
    CharSequence[] values = {"12sp", "14sp", "22sp"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.strathclyde);

        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.DarkTheme);
        }else{
            setTheme(R.style.LightTheme);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Immersive Scotland");

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        font = findViewById(R.id.font);
        font.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAlertDialogWithSwitchButton();
            }
        });



    }

    public void CreateAlertDialogWithSwitchButton() {
        AlertDialog.Builder builder = new AlertDialog.Builder(strath.this);
        builder.setTitle("Select your text size");
        textView = (TextView) findViewById(R.id.desc);
        builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {

                switch (item) {
                    case 0:
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                        break;
                    case 1:
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                        break;
                    case 2:
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
                        break;
                }
                alertDialog1.dismiss();
            }
        });

        alertDialog1 = builder.create();
        alertDialog1.show();

    }

    public void logout (MenuItem item){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), login.class));
        finish();
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
                Intent intentM = new Intent(this, MapsActivity.class);
                this.startActivity(intentM);
                break;


            case R.id.nav_info:
                Intent intentI = new Intent(this,Info.class);
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

    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

}

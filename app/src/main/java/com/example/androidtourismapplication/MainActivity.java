package com.example.androidtourismapplication;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.Window;
        import android.view.WindowManager;

        import android.os.Bundle;
        import android.view.MenuItem;
        import android.widget.ArrayAdapter;
        import android.widget.GridLayout;
        import android.widget.Spinner;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.ActionBarDrawerToggle;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.Toolbar;
        import androidx.cardview.widget.CardView;
        import androidx.core.view.GravityCompat;
        import androidx.drawerlayout.widget.DrawerLayout;
        import com.google.android.material.navigation.NavigationView;

        import java.lang.reflect.Array;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawer;
    GridLayout gridL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        gridL = (GridLayout)findViewById(R.id.gridL);

        setSingleEvent(gridL);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Explore");

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_menu, new MainActivity()).commit();


    }




    private void setSingleEvent(GridLayout gridL){
        for (int i =0; i<gridL.getChildCount(); i++) {

            CardView cardView = (CardView)gridL.getChildAt(i);
            final int finalI = i;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (finalI ==0){
                        Intent intent = new Intent(MainActivity.this, wallace.class);
                        startActivity(intent);
                    }
                    else  if (finalI ==1){
                        Intent intent = new Intent(MainActivity.this, sbb.class);
                        startActivity(intent);
                    }
                    else if (finalI ==2){
                        Intent intent = new Intent(MainActivity.this, smoo.class);
                        startActivity(intent);
                    }
                    else if (finalI ==3){
                        Intent intent = new Intent(MainActivity.this, ben.class);
                        startActivity(intent);
                    }
                    else if (finalI ==4){
                        Intent intent = new Intent(MainActivity.this, dun.class);
                        startActivity(intent);
                    }
                    else if (finalI ==5){
                        Intent intent = new Intent(MainActivity.this, lusk.class);
                        startActivity(intent);
                    }
                    else if (finalI ==6){
                        Intent intent = new Intent(MainActivity.this, pap.class);
                        startActivity(intent);
                    }
                    else if (finalI ==7){
                        Intent intent = new Intent(MainActivity.this, cullen.class);
                        startActivity(intent);
                    }
                    else if (finalI ==8){
                        Intent intent = new Intent(MainActivity.this, loch.class);
                        startActivity(intent);
                    }
                    else if (finalI ==9){
                        Intent intent = new Intent(MainActivity.this, strath.class);
                        startActivity(intent);
                    }
                    else if (finalI ==10){
                        Intent intent = new Intent(MainActivity.this, wsb.class);
                        startActivity(intent);
                    }
                    else if (finalI ==11){
                        Intent intent = new Intent(MainActivity.this, lin.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "please set an activity for this card", Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }





    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
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
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_menu, new MapFragment()).commit();
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

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



}


package com.example.androidtourismapplication;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.MenuItem;
        import android.view.Window;
        import android.view.WindowManager;

        import android.os.Bundle;
        import android.view.MenuItem;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.ActionBarDrawerToggle;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.Toolbar;
        import androidx.core.view.GravityCompat;
        import androidx.drawerlayout.widget.DrawerLayout;
        import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Explore");

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_menu, new HomeFragment()).commit();


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intentH = new Intent(this, HomeFragment.class);
                this.startActivity(intentH);
                break;


            case R.id.nav_fav:
                Intent intentF = new Intent(this, FavouritesFragment.class);
                this.startActivity(intentF);
                break;



            case R.id.nav_map:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_menu, new MapFragment()).commit();
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


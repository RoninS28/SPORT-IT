package com.example.temp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class SinglePlayer extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ForeFrag foreFrag = new ForeFrag();
    BackFrag backFrag = new BackFrag();
    WhoKnowsFrag whoKnowsFrag = new WhoKnowsFrag();
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;


    public SinglePlayer() {
    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_player_activity);


        toolbar = findViewById(R.id.toolbar);


        drawerLayout = findViewById(R.id.drawerLayout);
        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
        navigationView.bringToFront();
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        FirebaseAuth x;

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        Spinner spinnerPreferences = findViewById(R.id.spinnerTeams);
        String[] Preferences = new String[] {"Date", "Time", "Date-Time", "Team Name", "Team Id"};
        ArrayAdapter<String> preferenceAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, Preferences);
        //spinnerPreferences.setAdapter(preferenceAdapter);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId())
            {
                case R.id.nav_scrn1:
                    bottomNavigationView.setItemBackgroundResource(R.color.white);
                    setFragment(whoKnowsFrag);
                    return true;

                case R.id.nav_scrn2:
                    bottomNavigationView.setItemBackgroundResource(R.color.black);
                    setFragment(backFrag);
                    return true;

                case R.id.nav_scrn4:
                    bottomNavigationView.setItemBackgroundResource(R.color.white);
                    setFragment(foreFrag);
                    return true;

                default:
                    return false;
            }
        });


    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    public void setFragment(Fragment fragment1)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.MainFrame, fragment1).commit();
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                setFragment(whoKnowsFrag);
                break;

            case R.id.nav_side2:
                Toast.makeText(this, "Create Team", Toast.LENGTH_SHORT).show();
                setFragment(backFrag);
                break;

            case R.id.nav_side3:
                Toast.makeText(this, "Join a Team", Toast.LENGTH_SHORT).show();
                setFragment(foreFrag);
                break;

            case R.id.nac_myprofile:
                startActivity(new Intent(this, Create_Complete_Profiles.class));
                Toast.makeText(this, "Player Profile", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nac_team:
                startActivity(new Intent(this, Create_Profile_Team.class));
                Toast.makeText(this, "Create your own Team", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_share:
                Toast.makeText(this, "Share us", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_rateus:
                Toast.makeText(this, "Rate us", Toast.LENGTH_SHORT).show();
                break;

            default:
                Toast.makeText(this, "Nothing", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
package com.phon.elibrary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class DrawerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_drawer);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                drawerLayout.closeDrawers();

                if (menuItem.getItemId() == R.id.mnu_home) {
                    getSupportActionBar().setTitle("Home");
                    HomeFragment homeFragment = new HomeFragment();
                    Utility.displayFragment(homeFragment, getSupportFragmentManager(), R.id.lyt_fragment_container);
                } else if (menuItem.getItemId() == R.id.mnu_profile) {
                    getSupportActionBar().setTitle("Profile");
                    ProfileFragment profileFragment = new ProfileFragment();
                    Utility.displayFragment(profileFragment, getSupportFragmentManager(), R.id.lyt_fragment_container);
                } else {
                    getSupportActionBar().setTitle("Setting");
                    SettingFragment settingFragment = new SettingFragment();
                    Utility.displayFragment(settingFragment, getSupportFragmentManager(), R.id.lyt_fragment_container);
                }

                return true;
            }
        });

    }

}
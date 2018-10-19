package com.phon.elibrary;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class TabActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tab);

        // Add HomeFragment to the activity
        HomeFragment homeFragment = new HomeFragment();
        displayFragment(homeFragment);

        // Set listener on BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        // Or using other method to set listener on BottomNavigationView
        /*bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        });*/

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        if (menuItem.getItemId() == R.id.mnu_home) {
            HomeFragment homeFragment = new HomeFragment();
            Utility.displayFragment(homeFragment, getSupportFragmentManager(), R.id.lyt_fragment_container);
        } else if (menuItem.getItemId() == R.id.mnu_profile) {
            ProfileFragment profileFragment = new ProfileFragment();
            Utility.displayFragment(profileFragment, getSupportFragmentManager(), R.id.lyt_fragment_container);
        } else {
            SettingFragment settingFragment = new SettingFragment();
            Utility.displayFragment(settingFragment, getSupportFragmentManager(), R.id.lyt_fragment_container);
        }

        return true;
    }


    private void displayFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.lyt_fragment_container, fragment);
        fragmentTransaction.commit();
    }

}

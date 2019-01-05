package com.sigabe.sigabe;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.sigabe.sigabe.Emergency.EmergencyCall;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new Dashboard());
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_continer, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
                case R.id.navigation_home:
                    fragment = new Dashboard();
                break;
                case R.id.navigation_call:
                    fragment = new EmergencyCall();
                break;
                case R.id.navigation_contact:
                    fragment = new Contact();
                break;
                case R.id.navigation_profile:
                    fragment = new Profile();
                    break;
        }
        return loadFragment(fragment);
    }
}

package com.sigabe.sigabe.Content;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.sigabe.sigabe.R;

public class SurvivalDashboardTab extends AppCompatActivity {
    private static final String TAG = "SurvivalDashboardTab";

    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    private final int[] tabIcons = {R.drawable.ic_kebakaran, R.drawable.ic_lari};
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survival_dashboard_tab);
        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new DashboardAlam(), "Bencana Alam");
        adapter.addFragment(new DashboardSosialTab(), "Bencana Sosial");
        viewPager.setAdapter(adapter);
    }
}

package com.sigabe.sigabe.Content;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sigabe.sigabe.R;

public class ContentGempaTab extends AppCompatActivity {

    private static final String TAG = "ContentGempaTab";
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_gempa_tab);
        Log.d(TAG, "onCreate: Starting.");
        SectionsPageAdapter mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        ViewPager mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ConGempa1(), "Sebelum Bencana");
        adapter.addFragment(new ConGempa2(), "Setelah Bencana");
        viewPager.setAdapter(adapter);
    }
}

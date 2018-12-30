package com.sigabe.sigabe.Content;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sigabe.sigabe.Content.ContentJatuh;
import com.sigabe.sigabe.Content.SectionsPageAdapter;
import com.sigabe.sigabe.R;

public class ContentJatuhTab extends AppCompatActivity {

    private static final String TAG = "ContentJatuhTab";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_jatuh_tab);
        Log.d(TAG, "onCreate: Starting.");
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }
    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ContentJatuh(), "Saat Terjadi Bencana");
        viewPager.setAdapter(adapter);
    }
}

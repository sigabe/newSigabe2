package com.sigabe.sigabe.Content;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sigabe.sigabe.R;

public class ContentBanjirTab extends AppCompatActivity {
    private static final String TAG = "ContentBanjirTab";

    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    private final int[] tabIcons = {R.drawable.ic_kebakaran, R.drawable.ic_lari};
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_banjir_tab);
        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
//        setupTabIcons();
    }

//    private void setupTabIcons() {
//        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
//        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
//    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ConBanjir1(), "Sebelum Bencana");
        adapter.addFragment(new ConBanjir2(), "Setelah Bencana");
        viewPager.setAdapter(adapter);
    }
}

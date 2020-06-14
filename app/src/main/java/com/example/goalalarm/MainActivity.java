package com.example.goalalarm;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());


        // Add Fragment Here

        adapter.AddFragment(new HomeFragment(),"");
        adapter.AddFragment(new SubscribeFragment(), "" );
        adapter.AddFragment(new LatestFragment(),"");
        adapter.AddFragment(new AlarmFragment(),"");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_assistant_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_subject_black_24dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_alarm_black_24dp);

        //Remove shadow from action bar

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }
}

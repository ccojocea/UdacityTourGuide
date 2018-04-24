package com.example.ccojo.clujtourguideapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CategoryActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        categoryAdapter = new CategoryAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(categoryAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}

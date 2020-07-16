package app.shijin.shijinnewsapp;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import app.shijin.shijinnewsapp.adapter.CustomAdapter;


public class MainActivity extends AppCompatActivity {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        ViewPager myViewPager;
        TabLayout myViewTabLayout;


        myViewPager = findViewById(R.id.simpleViewPager);
        CustomAdapter adapter = new CustomAdapter(mContext, getSupportFragmentManager());
        myViewPager.setAdapter(adapter);


        myViewTabLayout = findViewById(R.id.simpleTabLayout);
        myViewTabLayout.setupWithViewPager(myViewPager);


    }
}
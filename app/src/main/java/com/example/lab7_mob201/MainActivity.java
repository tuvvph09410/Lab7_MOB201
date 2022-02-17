package com.example.lab7_mob201;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lab7_mob201.Fragment.Fragment_Bai1;
import com.example.lab7_mob201.Fragment.Fragment_Bai2;
import com.example.lab7_mob201.Fragment.Fragment_Bai3;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initViewById();
        this.initToolBar();
        this.initBottomNav();
    }

    private void initToolBar() {
        actionBar = getSupportActionBar();
    }

    private void initBottomNav() {
        BottomNavigationView.OnNavigationItemSelectedListener itemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_bai1:
                        initFragment(new Fragment_Bai1());
                        checkedNavId(R.id.menu_bai1);
                        actionBar.setTitle("Bai1_Lab7_MOB201");
                        break;
                    case R.id.menu_bai2:
                        initFragment(new Fragment_Bai2());
                        checkedNavId(R.id.menu_bai2);
                        actionBar.setTitle("Bai2_Lab7_MOB201");
                        break;
                    case R.id.menu_bai3:
                        initFragment(new Fragment_Bai3());
                        checkedNavId(R.id.menu_bai3);
                        actionBar.setTitle("Bai3_Lab7_MOB201");
                        break;
                }
                return true;
            }
        };
        this.bottomNavigationView.setOnNavigationItemSelectedListener(itemSelectedListener);
        this.actionBar.setTitle("Bai1_Lab7_MOB201");
        initFragment(new Fragment_Bai1());
        checkedNavId(R.id.menu_bai1);
    }

    private void initViewById() {
        this.bottomNavigationView = findViewById(R.id.botton_nav);
    }

    private void initFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void checkedNavId(int item) {
        this.bottomNavigationView.getMenu().findItem(item).setChecked(true);
    }
}
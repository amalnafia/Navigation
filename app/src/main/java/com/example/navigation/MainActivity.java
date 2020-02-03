package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.navigation.Fragments.HomeFragment;
import com.example.navigation.Fragments.OrdersFragment;
import com.example.navigation.Fragments.ProfileFragment;
import com.example.navigation.Fragments.ShopsFragment;
import com.example.navigation.Fragments.SittingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    Toolbar toolbarTop;
    private static final String TAG = "MainActivity";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbarTop = findViewById(R.id.toolbarTop);
        setSupportActionBar(toolbarTop);
        //toolbarTop.setTitle("");
        MainActivity.this.setTitle("");
        textView = findViewById(R.id.title);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mainNavigationFragment);
        NavigationUI.setupWithNavController(bottomNavigationView,
                navHostFragment.getNavController());

//
//        setDefaultFragment();
//
//
//        bottomNavigation = findViewById(R.id.bottom_navigation);
//        bottomNavigation.setSelectedItemId(R.id.homeFragment);
//
//        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
//
//    }
//
//    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    switch (item.getItemId()) {
//                        case R.id.shopsFragment:
//                            textView.setText("Shops");
//                            openFragment(new ShopsFragment());
//                            Log.e(TAG, "onNavigationItemSelected: ");
//                            return true;
//                        case R.id.ordersFragment:
//                            textView.setText("Orders");
//                            openFragment(new OrdersFragment());
//                            return true;
//                        case R.id.homeFragment:
//                            textView.setText("Home");
//
//                            openFragment(new HomeFragment());
//
//                            return true;
//                        case R.id.sittingsFragment:
//                            textView.setText("Sittings");
//
//                            openFragment(new SittingsFragment());
//                            return true;
//                        case R.id.profileFragment:
//                            textView.setText("Profile");
//
//                            openFragment(new ProfileFragment());
//                            return true;
//                    }
//                    return false;
//                }
//            };
//
//    public void openFragment(Fragment fragment) {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.container, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
//    private void setDefaultFragment() {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.container,new HomeFragment());
//        transaction.commit();
//
//    }
    }
}
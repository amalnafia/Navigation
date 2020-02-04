package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    Toolbar toolbarTop;
    private static final String TAG = "MainActivity";
    TextView textView;
    private ImageView profileImageView;
    MyInterface interface1;
    ImageView btnChange;

    public void setInterface1(MyInterface interface1) {
        this.interface1 = interface1;
    }

    private static MainActivity mainActivity;

    public static MainActivity getInstance() {
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
        toolbarTop = findViewById(R.id.main_bar);
        setSupportActionBar(toolbarTop);
        MainActivity.this.setTitle("");
        textView = findViewById(R.id.title);
        profileImageView = findViewById(R.id.drawer_image);
        btnChange = findViewById(R.id.drawer_image);
        btnChange.setOnClickListener(v -> {
            if (interface1 != null) {
                interface1.buttonClicked();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mainNavigationFragment);
        NavigationUI.setupWithNavController(bottomNavigationView,
                navHostFragment.getNavController());
        navHostFragment.getNavController().addOnDestinationChangedListener(onDestinationChangedListener);
    }

    private NavController.OnDestinationChangedListener onDestinationChangedListener = new NavController.OnDestinationChangedListener() {
        @Override
        public void onDestinationChanged(@NonNull NavController controller,
                                         @NonNull NavDestination destination, @Nullable Bundle arguments) {
            switch (destination.getId()) {
                case R.id.profile_fragment:
                    textView.setText("Profile");
                    profileImageView.setVisibility(View.VISIBLE);
                    break;
                default:
                    profileImageView.setVisibility(View.GONE);
            }
        }
    };



}
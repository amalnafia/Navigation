package com.example.navigation.Fragments;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.navigation.MainActivity;
import com.example.navigation.MyInterface;
import com.example.navigation.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileFragment extends Fragment implements MyInterface {

    ActionBarDrawerToggle actionBarDrawerToggle;
    private AppBarConfiguration mAppBarConfiguration;
    //    @BindView(R.id.image_profile)
//    Button hamMenu;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        MainActivity.getInstance().setInterface1(this);
    }


    @OnClick(R.id.login_text_view)
    public void onViewClicked() {

        Toast.makeText(getContext(), "login login ", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void buttonClicked() {
        mDrawer.openDrawer(GravityCompat.START);
    }
}
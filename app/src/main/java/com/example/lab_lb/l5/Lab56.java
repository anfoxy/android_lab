package com.example.lab_lb.l5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lab_lb.R;
import com.google.android.material.navigation.NavigationView;

public class Lab56 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab56);

        NavigationView navView = findViewById(R.id.L7NavView);
        navView.setNavigationItemSelectedListener(this);

        NavigationView navView2 = findViewById(R.id.L7NavView2);
        navView2.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        TextView tv = findViewById(R.id.TextView);
        tv.setText(menuItem.getTitle());
        DrawerLayout drawer = findViewById(R.id.L7DrawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        drawer.closeDrawer(GravityCompat.END);

        return true;
    }
}

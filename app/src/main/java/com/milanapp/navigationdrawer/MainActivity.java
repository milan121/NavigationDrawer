package com.milanapp.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public   class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

private FrameLayout frameLayout;
private static final int HOME_FRAGMENT = 0;
private int CurrentFragment = -1;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.main_frame_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawer.setDrawerListener(toggle);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setBackgroundColor(getResources().getColor(android.R.color.white));
        navigationView.setNavigationItemSelectedListener(this);

        setfragment(new HomeFragment(), HOME_FRAGMENT);
        }

@Override
public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
        drawer.closeDrawer(GravityCompat.START);
        } else {
        super.onBackPressed();
        }
        }

@Override
public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        }

@Override
public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_whatsapp) {
        Toast.makeText(this, "whatsapp", Toast.LENGTH_SHORT).show();
        return true;
        } else if (id == R.id.action_search) {
        Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();
        return true;
        }

        return super.onOptionsItemSelected(item);
        }

@SuppressWarnings("StatementWithEmptyBody")
@Override
public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_download) {
        // Handle the camera action
        Toast.makeText(this, "download", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_favourite) {
        //////////////
        Toast.makeText(this, "favourite", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_privacy) {
        //////////////
        Toast.makeText(this, "privacy", Toast.LENGTH_SHORT).show();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
        }


private void setfragment(Fragment fragment, int fragmentNo) {

        if (fragmentNo != CurrentFragment) {
        CurrentFragment = fragmentNo;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fragment_fade_enter, R.anim.fragment_fade_exit);
        fragmentTransaction.replace(frameLayout.getId(), fragment);
        fragmentTransaction.commit();
        }


        }


}
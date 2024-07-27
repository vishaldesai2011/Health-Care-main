package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.healthcare.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity {
//   ActivityMainBinding binding;
    TextView txt;
    ActionBar actionBar;
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_home);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Profile Activity");

        navigationView = findViewById(R.id.bottomNavigationView);
        navigationView.setOnNavigationItemSelectedListener(selectedListener);
        actionBar.setTitle("Home");

        Home_Frag fragment = new Home_Frag();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment, "");
        fragmentTransaction.commit();


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            String uid = user.getUid();
            String email = user.getEmail();
        } else {

        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        // first parameter is the file for icon and second one is menu
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // We are using switch case because multiple icons can be kept
        switch (item.getItemId()) {
            case R.id.shareButton:

                Intent sharingIntent = new Intent(Intent.ACTION_SEND);

                // type of the content to be shared
                sharingIntent.setType("text/plain");

                // Body of the content
                String shareBody = "Download Health Care app and Buy HealthCare Product  Download link here: https://app.healthcare";

                // subject of the content. you can share anything
                String shareSubject = "Health Care";

                // passing body of the content
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

                // passing subject of the content
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                break;

            case R.id.Order:
                startActivity(new Intent(Home.this,PastOrders.class));
        }

        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.homes:
                    actionBar.setTitle("Home");
                    Home_Frag fragment = new Home_Frag();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout, fragment, "");
//
                    fragmentTransaction.commit();
                    return true;

                case R.id.profiles:
                    actionBar.setTitle("Profile");
                    MyAccount fragment1 = new MyAccount();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frame_layout, fragment1, "");

                    fragmentTransaction1.commit();
                    return true;

                case R.id.app:
                    actionBar.setTitle("Book An Appointment");
                    Setting_frag fragment2 = new Setting_frag();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.frame_layout, fragment2, "");
                    fragmentTransaction2.commit();
                    return true;

                case R.id.order:
                actionBar.setTitle("SHOP BY HEALTH CONDITIONS");
                Order_Frag fragment3 = new Order_Frag();
                FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.frame_layout, fragment3, "");
                fragmentTransaction3.commit();
                return true;
        }

            return false;
        }
    };
//    Fire Base
        //        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");
//        https://www.geeksforgeeks.org/navigation-drawer-in-android/



}
package com.mahfujshaan.cse486.finalproject;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Homepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    FirebaseAuth mFirebaseAuth;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new AdvisingFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_advising);
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_advising:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AdvisingFragment()).commit();
                break;
            case R.id.nav_attendance:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AttendanceFragment()).commit();
                break;
            case R.id.nav_degree:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DegreeFragment()).commit();
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_course_drop:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DropCourseFragment()).commit();
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
                case R.id.nav_faculty_evaluation:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EvaluationFragment()).commit();
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
                case R.id.nav_faq:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FAQFragment()).commit();
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
                case R.id.nav_grades:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new GradesFragment()).commit();
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
                case R.id.nav_help:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HelpFragment()).commit();
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
                case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
                case R.id.nav_logout:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LogoutFragment()).commit();
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
                case R.id.nav_online_services:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ServicesFragment()).commit();
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
                case R.id.nav_payments:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PaymentFragment()).commit();
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
                case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
                case R.id.nav_sms_history:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SMSFragment()).commit();
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
package com.mahfujshaan.cse486.studentportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Homepage extends AppCompatActivity {


    Button logout;

    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_main);
//LOGOUT BUTTON FUNCTION
        //logout = findViewById(R.id.logout);

        // logout.setOnClickListener(new View.OnClickListener() {
        // @Override
        // public void onClick(View v) {
        //FirebaseAuth.getInstance().signOut();
        //startActivity(new Intent(getApplicationContext(),MainActivity.class));
        //finish();
        // }
        //});
















    }
}
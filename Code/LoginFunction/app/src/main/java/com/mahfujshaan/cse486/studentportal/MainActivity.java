package com.mahfujshaan.cse486.studentportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText studentID, password;
    Button buttonLogin;
    Button newStudent;
    Button forgotPassword;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mFirebaseAuth = FirebaseAuth.getInstance();
        studentID = findViewById(R.id.student_id_box);
        password = findViewById(R.id.password_box);
    }
}
package com.mahfujshaan.cse486.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class ForgotPassword extends AppCompatActivity {
    EditText studentEmail;
    Button sendOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        studentEmail = findViewById(R.id.student_email);
        sendOTP = findViewById(R.id.send_otp);

        sendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(ForgotPassword.this, "OTP Sent", Toast.LENGTH_SHORT).show();
            }
        });


    }
}

package com.mahfujshaan.cse486.studentportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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
        password = findViewById(R.id.password_box_login);
        buttonLogin = findViewById(R.id.login_button);
        newStudent = findViewById(R.id.new_student);
        forgotPassword = findViewById(R.id.forgot_password);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentid = studentID.getText().toString();
                String PassWord = password.getText().toString();

                if(TextUtils.isEmpty(studentid)){
                    studentID.setError("Enter Student ID");
                    return;
                }
                if(TextUtils.isEmpty(PassWord)){
                    password.setError("Password is required");
                    return;
                }
                //authentication
                mFirebaseAuth.signInWithEmailAndPassword(studentid,PassWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
if(task.isSuccessful()){
    Toast.makeText(MainActivity.this, "Sign In Successful", Toast.LENGTH_SHORT).show();
    startActivity(new Intent(getApplicationContext(),Homepage.class));
}
else {
    Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
}
                    }
                });

            }
        });

        newStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUp.class));
            }
        });


        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent forgot = new Intent (MainActivity.this,Homepage.class);
               startActivity(forgot);
            }
        });
    }
}


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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText studentID, password;
    Button buttonLogin;
    Button newStudent;
    Button forgotPassword;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

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


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(MainActivity.this, "Logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, LandingPage.class);
                    startActivity(i);
                } //else if (mFirebaseUser == null){
                    //Toast.makeText(MainActivity.this, "User not Registered, Sign Up First", Toast.LENGTH_SHORT).show();
                }
           // }
        };


        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String studentid = studentID.getText().toString();
                String passWord = password.getText().toString();
                if (TextUtils.isEmpty(studentid)) {
                    studentID.setError("Provide Student ID");
                    studentID.requestFocus();
                } else if (TextUtils.isEmpty(passWord)) {
                    password.setError("Enter the correct Password");
                    password.requestFocus();
                } else if (TextUtils.isEmpty(studentid) && TextUtils.isEmpty(passWord)) {
                    Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_LONG).show();
                }

                //Firebase Auth
                else if (!TextUtils.isEmpty(studentid) && TextUtils.isEmpty(passWord)) {
                    mFirebaseAuth.signInWithEmailAndPassword(studentid, passWord).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                                Intent home = new Intent(MainActivity.this, LandingPage.class);
                                startActivity(home);
                            } else {
                                Toast.makeText(MainActivity.this, "Login Unsuccessful, Please Try Again!!", Toast.LENGTH_LONG).show();
                            }

                        }
                    });
                }

                else {
                    Toast.makeText(MainActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                }
            }
        });

        newStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this,SignUp.class);
                startActivity(i);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent (MainActivity.this,LandingPage.class);
                startActivity(login);
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgot = new Intent (MainActivity.this,LandingPage.class);
                startActivity(forgot);
            }
        });

    }
@Override
    protected void onStart(){
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);

}

}


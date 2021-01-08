package com.mahfujshaan.cse486.studentportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        password = findViewById(R.id.password_box_confirm);
        buttonLogin = findViewById(R.id.sign_up_button);


        newStudent = findViewById(R.id.new_student);
        forgotPassword = findViewById(R.id.forgot_password);

        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String studentid = studentID.getText().toString();
                String passWord = password.getText().toString();
                if(TextUtils.isEmpty(studentid))
                {
                    studentID.setError("Provide Student ID");
                    studentID.requestFocus();
                }
                else if(TextUtils.isEmpty(passWord))
                {
                    password.setError("Enter the correct Password");
                    password.requestFocus();
                }
               else if(TextUtils.isEmpty(studentid) && TextUtils.isEmpty(passWord) )
                {
                    Toast.makeText(MainActivity.this,"Fields are empty",Toast.LENGTH_LONG).show();
                }

               //Firebase Auth
                else if(!TextUtils.isEmpty(studentid) && TextUtils.isEmpty(passWord) ){



                }


            }

        });
    }
}
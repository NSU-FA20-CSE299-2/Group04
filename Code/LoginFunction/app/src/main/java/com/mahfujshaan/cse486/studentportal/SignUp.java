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

public class SignUp extends AppCompatActivity{
    EditText studentID, newPassword,confirmPassword;
    Button buttonSignUp;


    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mFirebaseAuth = FirebaseAuth.getInstance();
        studentID = findViewById(R.id.student_id_box);
        newPassword = findViewById(R.id.password_box_new);
        confirmPassword = findViewById(R.id.password_box_confirm);
        buttonSignUp = findViewById(R.id.sign_up_button);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String studentid = studentID.getText().toString();
                String newPassWord = newPassword.getText().toString();
                String confirmPassWord = confirmPassword.getText().toString();
                if(TextUtils.isEmpty(studentid))
                {
                    studentID.setError("Provide Student ID");
                    studentID.requestFocus();
                }
                else if(TextUtils.isEmpty(newPassWord))
                {
                    newPassword.setError("Enter a Password");
                    newPassword.requestFocus();
                }
                else if(TextUtils.isEmpty(confirmPassWord))
                {
                    confirmPassword.setError("Passwords are wrong");
                    confirmPassword.requestFocus();
                }
                else if(TextUtils.isEmpty(studentid) && TextUtils.isEmpty(newPassWord)&& TextUtils.isEmpty(confirmPassWord) )
                {
                    Toast.makeText(SignUp.this,"Fields are empty",Toast.LENGTH_LONG).show();
                }

                //Firebase Auth
                else if(!TextUtils.isEmpty(studentid) && TextUtils.isEmpty(newPassWord) ){

mFirebaseAuth.createUserWithEmailAndPassword(studentid,confirmPassWord).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
    @Override

    //OnComplete
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(!task.isSuccessful())
        {
            Toast.makeText(SignUp.this,"Sign Up Unsuccessful!!!",Toast.LENGTH_LONG).show();
        }
        else{startActivity(new Intent(SignUp.this,MainActivity.class));

        }
    }
});
                }
                else{
                    Toast.makeText(SignUp.this,"Error!!!",Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}

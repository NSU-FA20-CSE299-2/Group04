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


        studentID = findViewById(R.id.student_id_box);
        newPassword = findViewById(R.id.password_box_new);
        confirmPassword = findViewById(R.id.password_box_login);
        buttonSignUp = findViewById(R.id.sign_up_button);
        mFirebaseAuth = FirebaseAuth.getInstance();

if(mFirebaseAuth.getCurrentUser() != null){
    startActivity(new Intent(getApplicationContext(),MainActivity.class));
}



        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentid = studentID.getText().toString();
                String newPassWord = newPassword.getText().toString();
                String confirmPassWord = confirmPassword.getText().toString();

                if(TextUtils.isEmpty(studentid)){
                    studentID.setError("Enter Student ID");
                    return;
                }
                if(TextUtils.isEmpty(newPassWord)){
                    newPassword.setError("Password is required");
                    return;
                }
                if(TextUtils.isEmpty(confirmPassWord)){
                    confirmPassword.setError("Passwords are wrong");
                    return;
                }

//Condition Pass
mFirebaseAuth.createUserWithEmailAndPassword(studentid,newPassWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
if(task.isSuccessful()){
    Toast.makeText(SignUp.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
startActivity(new Intent(getApplicationContext(),Homepage.class));
}

else {
    Toast.makeText(SignUp.this, "Error", Toast.LENGTH_SHORT).show();
}
    }
});
            }
        });







    }
}

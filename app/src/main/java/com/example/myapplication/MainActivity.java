package com.example.myapplication;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    EditText emailstudent;
    EditText passwordstudent;
    Button login;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_activity);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        emailstudent = findViewById(R.id.emaillogin);
        passwordstudent = findViewById(R.id.passwordlogin);
        login = findViewById(R.id.loginButton);
        signup = findViewById(R.id.signupButton);
        signup.setPaintFlags(signup.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        //INTENT TO STUDENT CLASS
        login.setOnClickListener(
                new View.OnClickListener() {
            public void onClick(View arg0) {

                //USING EMAIL
                firebaseAuth.signInWithEmailAndPassword(emailstudent.getText().toString(), passwordstudent .getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(MainActivity.this, Student_Profile.class));

                        } else {
                            Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

        //INTENT TO STUDENT SIGN UP
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent;
                myIntent = new Intent(MainActivity.this,
                        Student_Sign_up.class);
                startActivity(myIntent);
            }
        });
    }

}

package com.example.myapplication;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class Student_Sign_up extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText emailStudent;
    EditText passwordStudent;
    EditText repassword;
    Button signup;
    Button backTologin;
    Dialog dialog;

    private static final String TAG = "Email Password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_signup_activity);

        mAuth = FirebaseAuth.getInstance();
        signup = findViewById(R.id.signupUser);
        backTologin = findViewById(R.id.backtologinButton);

        emailStudent = findViewById(R.id.emailsignup);
        passwordStudent = findViewById(R.id.passwordsignup);
        repassword = findViewById(R.id.repasswordsignup);



        //SIGN UP NEW USERS
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Student_Sign_up.this);
                builder.setView(R.layout.progress);
                dialog = builder.create();

                String emailString = emailStudent.getText().toString();
                String passwordString = passwordStudent.getText().toString();
                String repasswordString = repassword.getText().toString();

                if(passwordString.equals(repasswordString)) {

                    setDialog(true);
                    int a=10;
                    String name1 = emailString;
                    String name2 = passwordString;

                    mAuth.createUserWithEmailAndPassword(emailString,passwordString)
                            .addOnCompleteListener(Student_Sign_up.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");
                                        //FirebaseUser user = mAuth.getCurrentUser();
                                        Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();
                                        setDialog(false);

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(Student_Sign_up.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                        setDialog(false);
                                    }
                                }
                            });
                }
                else{
                    Toast.makeText(Student_Sign_up.this, "Passwords Do Not Match",
                            Toast.LENGTH_SHORT).show();
                }
            }});


        //BACK TO LOGIN-->MAIN ACTIVITY
        backTologin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent;
                myIntent = new Intent(Student_Sign_up.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });

    }
    private void setDialog(boolean show){
        if (show) {
            Toast.makeText(Student_Sign_up.this, "Just testing 1",
                    Toast.LENGTH_LONG).show();
            dialog.show();
        }
        else
            dialog.dismiss();
    }
}


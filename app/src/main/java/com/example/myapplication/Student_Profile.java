package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class Student_Profile extends AppCompatActivity {

    TextView nametext;
    TextView UIDtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_profile_activity);

        nametext = findViewById(R.id.name);
        UIDtext = findViewById(R.id.UID);

        String personName = "";
        String uid = "";

        //CURRENT USER
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);



        if (acct != null) {
            uid = acct.getId();
            personName = acct.getDisplayName();
            /*String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            Uri personPhoto = acct.getPhotoUrl();*/
        }

        nametext.setText(personName);
        UIDtext.setText(uid);

    }

}

package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {

     /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splash_screen);
//Tune yehi agar comment kar rakha hai toh kaise uska view set hoga?
        //isko dalne se app pura hi crash ho jata hai
        // peeche ki image is too large in size... either compress it or use some other image
        //oh okay
        //and the google sign in?

        // Duration of wait
        int SPLASH_DISPLAY_LENGTH = 1000;

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                startActivity(mainIntent);
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
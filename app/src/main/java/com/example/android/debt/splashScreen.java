package com.example.android.debt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public class splashScreen extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    private Context _ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        _ctx = this;

        /** Hiding Title bar of this activity screen */
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//
//        /** Making this activity, full screen */
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

            Thread myThread = new Thread() {

                @Override
                public void run() {

                    try {
                        sleep(3000);

                        Intent intent = new Intent(_ctx, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        myThread.start();


    }// end of onCreate
}

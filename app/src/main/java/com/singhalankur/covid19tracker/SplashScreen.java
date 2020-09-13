package com.singhalankur.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {

    public static int SPLASH_TIMER = 3500;

    //Variables
    LottieAnimationView appIcon;
    TextView poweredByLine, appTitle;

    //Animation Variables
    Animation sideAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();

        //Hooks
        appIcon = findViewById(R.id.lottie);
        appTitle = findViewById(R.id.app_title);
        poweredByLine = findViewById(R.id.powered_by_text);

        //Hooks Animations
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        //Set Animations
        appIcon.setAnimation(bottomAnim);
        appTitle.setAnimation(sideAnim);
        poweredByLine.setAnimation(sideAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, SPLASH_TIMER);
    }
}
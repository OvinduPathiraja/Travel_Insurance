package com.example.travelinsurance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {
//    TextView appname;
//    TextView description;
    LottieAnimationView lottie;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        lottie = findViewById(R.id.lottie);
//        appname = findViewById(R.id.logo);
//        description = findViewById(R.id.logodes);


        lottie.animate().translationX(0).setDuration(2000).setStartDelay(0);

//        appname.animate().translationY(-100).setDuration(1000).setStartDelay(0);
//        description.animate().translationY(-100).setDuration(1000).setStartDelay(0);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(),SignInActivity.class);
                startActivity(i);
            }
        },5000);

    }
}

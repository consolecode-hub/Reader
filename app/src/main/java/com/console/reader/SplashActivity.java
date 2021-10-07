package com.console.reader;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(AppCompatDelegate.getDefaultNightMode() ==AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.NightMode);
        }else{
            setTheme(R.style.AppTheme);
        }
        setContentView(R.layout.splash);
        getSupportActionBar().hide();


        final ImageView imageView = (ImageView) findViewById(R.id.splash);
        Animation animRotate= AnimationUtils.loadAnimation(this, R.anim.fadein);
        imageView.startAnimation(animRotate);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(getBaseContext(), Article.class);
                startActivity(i);
                overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
                finish();
            }
        }, 2000);   //2 seconds
    }
}
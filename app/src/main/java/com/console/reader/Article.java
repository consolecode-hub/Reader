package com.console.reader;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.console.reader.databinding.ArticalBinding;

public class Article extends AppCompatActivity {
    private ArticalBinding binding;
    ImageButton ThemeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(AppCompatDelegate.getDefaultNightMode() ==AppCompatDelegate.MODE_NIGHT_YES){

            setTheme(R.style.NightMode);
        }else{
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);

        binding = ArticalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide(); // hide the title bar
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_artical);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        navView.setItemIconTintList(null);

        // switch the theme
        ThemeSwitch = findViewById(R.id.ThemeSwitch);
        if(AppCompatDelegate.getDefaultNightMode() ==AppCompatDelegate.MODE_NIGHT_YES){
            ThemeSwitch.setImageResource(R.drawable.light);
        }else{
            ThemeSwitch.setImageResource(R.drawable.night);
        }

        ThemeSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(AppCompatDelegate.getDefaultNightMode() ==AppCompatDelegate.MODE_NIGHT_YES){
                    ThemeSwitch.setImageResource(R.drawable.light);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }else{
                    ThemeSwitch.setImageResource(R.drawable.night);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                restartApp();
            }
        });


    }


    private void restartApp(){
        //Go to the same class as Intent
        //With setFlags, the application is prevented from being a black screen.
        Intent i = new Intent(getApplicationContext(), Article.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i);
        finish();


    }


}
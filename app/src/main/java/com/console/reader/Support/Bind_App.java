package com.console.reader.Support;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.multidex.MultiDex;
import android.text.TextUtils;
import android.view.WindowManager;



import java.util.Stack;

public class Bind_App extends Application {

    public static final String TAG = Bind_App.class.getSimpleName();

    private Stack<Activity> classes = new Stack<Activity>();

    private static Bind_App mInstance;


    @Override
    public void onCreate() {
        super.onCreate();

        FontsOverride.setDefaultFont(this, "DEFAULT", "Roboto-Thin.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "Roboto-Thin.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "Roboto-Thin.ttf");
        //  This FontsOverride comes from the example I posted above
  //      setupActivityListener();

        mInstance = this;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        MultiDex.install(this);
    }

    public static synchronized Bind_App getInstance() {
        return mInstance;
    }

    private void setupActivityListener() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);            }
            @Override
            public void onActivityStarted(Activity activity) {
            }
            @Override
            public void onActivityResumed(Activity activity) {

            }
            @Override
            public void onActivityPaused(Activity activity) {

            }
            @Override
            public void onActivityStopped(Activity activity) {
            }
            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }
            @Override
            public void onActivityDestroyed(Activity activity) {
            }
        });
    }
}
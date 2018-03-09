package com.potluck;

import android.app.Application;

import timber.log.Timber;


public class PotluckApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
    }
}

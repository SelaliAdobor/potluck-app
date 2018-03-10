package com.potluck.activity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    @Provides
    MainActivity provideMainActivity(MainActivity mainActivity){
        return mainActivity;
    }

}

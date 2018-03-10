package com.potluck.dagger;

import com.potluck.activity.MainActivity;
import com.potluck.activity.MainActivityModule;
import com.potluck.browser.BrowserFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MainActivityModule.class, BrowserFragmentProvider.class})
    abstract MainActivity bindMainActivity();

}
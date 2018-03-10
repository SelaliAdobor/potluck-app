package com.potluck.browser;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BrowserFragmentProvider {

    @ContributesAndroidInjector(modules = BrowserFragmentModule.class)
    abstract BrowserFragment provideDetailFragmentFactory();
}
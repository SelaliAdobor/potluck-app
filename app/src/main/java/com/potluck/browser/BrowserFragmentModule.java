package com.potluck.browser;

import dagger.Module;
import dagger.Provides;

@Module
public class BrowserFragmentModule {
    @Provides
    BrowserFragment provideBrowserFragment(BrowserFragment browserFragment){
        return browserFragment;
    }

}

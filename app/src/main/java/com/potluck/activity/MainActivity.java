package com.potluck.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.potluck.R;
import com.potluck.browser.BrowserFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import java9.util.function.Supplier;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }

    public static String BROWSER_FRAGMENT = "BrowserFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            goToBrowser();
        }
    }

    private void goToBrowser() {
        goToFragment(BROWSER_FRAGMENT, BrowserFragment::newInstance);
    }

    private <T extends Fragment> void goToFragment(String fragmentName, Supplier<T> fragmentSupplier) {
        boolean wasOnBackstack = getSupportFragmentManager().popBackStackImmediate(fragmentName, 0);

        if (wasOnBackstack) {
            return;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, fragmentSupplier.get())
                .addToBackStack(fragmentName)
                .commit();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

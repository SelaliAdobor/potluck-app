package com.potluck;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.potluck.browser.BrowserFragment;

import java9.util.function.Supplier;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
    public static String BROWSER_FRAGMENT = "BrowserFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

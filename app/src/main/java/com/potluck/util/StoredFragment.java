package com.potluck.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import icepick.Icepick;

public class StoredFragment extends Fragment {
    protected static void storeArguments(Fragment fragment){
        Bundle argumentBundle = new Bundle();
        Icepick.saveInstanceState(fragment,argumentBundle);
        fragment.setArguments(argumentBundle);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }
}

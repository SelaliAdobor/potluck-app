package com.potluck.browser;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.potluck.R;
import com.potluck.util.StoredFragment;

import butterknife.ButterKnife;


public class BrowserFragment extends StoredFragment {
    public BrowserFragment() {
    }

    public static BrowserFragment newInstance() {
        BrowserFragment fragment = new BrowserFragment();
        storeArguments(fragment);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_browser, container, false);
        ButterKnife.bind(inflatedView);
        return inflatedView;
    }

}

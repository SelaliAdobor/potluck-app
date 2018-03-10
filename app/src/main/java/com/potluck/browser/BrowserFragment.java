package com.potluck.browser;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.potluck.R;
import com.potluck.util.StoredFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public class BrowserFragment extends StoredFragment {
    public static final String MAP_FRAGMENT_TAG = "MapFragment";

    private Unbinder unbinder;

    public BrowserFragment() {
    }

    public static BrowserFragment newInstance() {
        BrowserFragment fragment = new BrowserFragment();
        storeArguments(fragment);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onMapReady(GoogleMap map){
    }

    @Override
    public void onResume() {
        super.onResume();
        setupMap();
    }

    private void setupMap() {
        SupportMapFragment fragment = (SupportMapFragment) getChildFragmentManager().findFragmentByTag("MapFragment");
        if(fragment == null){
            fragment = SupportMapFragment.newInstance();
            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.browser_map_container, fragment, MAP_FRAGMENT_TAG)
                    .commit();
        }

        fragment.getMapAsync(this::onMapReady);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_browser, container, false);
        unbinder = ButterKnife.bind(this, inflatedView);
        return inflatedView;
    }

}

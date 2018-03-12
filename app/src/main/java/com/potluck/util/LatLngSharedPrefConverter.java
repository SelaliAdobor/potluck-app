package com.potluck.util;

import android.support.annotation.NonNull;

import com.f2prateek.rx.preferences2.Preference;
import com.google.android.gms.maps.model.LatLng;


public class LatLngSharedPrefConverter implements Preference.Converter<LatLng> {
    public static LatLngSharedPrefConverter INSTANCE = new LatLngSharedPrefConverter();
    @NonNull
    @Override
    public LatLng deserialize(@NonNull String serialized) {
        String[] splitLatLng = serialized.split(",");
        if (splitLatLng.length != 2) {
            throw new RuntimeException("Unable to deserialize LatLng: " + serialized);
        }
        Double lat = Double.parseDouble(splitLatLng[0]);
        Double lng = Double.parseDouble(splitLatLng[1]);
        return new LatLng(lat,lng);
    }

    @NonNull
    @Override
    public String serialize(@NonNull LatLng value) {
        return new StringBuffer()
                .append(value.latitude)
                .append(",")
                .append(value.longitude)
                .toString();
    }
}
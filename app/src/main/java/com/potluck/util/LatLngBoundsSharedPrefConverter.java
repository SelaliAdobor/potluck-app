package com.potluck.util;

import android.support.annotation.NonNull;

import com.f2prateek.rx.preferences2.Preference;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import timber.log.Timber;


public class LatLngBoundsSharedPrefConverter implements Preference.Converter<LatLngBounds> {
    private static final String DELIMITER = ",";
    public static LatLngBoundsSharedPrefConverter INSTANCE = new LatLngBoundsSharedPrefConverter();
    @NonNull
    @Override
    public LatLngBounds deserialize(@NonNull String serialized) {
        String[] splitLatLng = serialized.split(DELIMITER);
        if (splitLatLng.length != 4) {
            Timber.e(new RuntimeException("Unable to deserialize LatLng: " + serialized));
            return new LatLngBounds(new LatLng(41.3083, 72.9279),new LatLng(42.3083, 73.9279));
        }

        Double minLat = Double.parseDouble(splitLatLng[0]);
        Double minLng = Double.parseDouble(splitLatLng[1]);
        Double maxLat = Double.parseDouble(splitLatLng[2]);
        Double maxLng = Double.parseDouble(splitLatLng[3]);

        return new LatLngBounds(new LatLng(minLat,minLng),new LatLng(maxLat,maxLng));
    }

    @NonNull
    @Override
    public String serialize(@NonNull LatLngBounds value) {
        return new StringBuffer()
                .append(value.southwest.latitude)
                .append(DELIMITER)
                .append(value.southwest.longitude)
                .append(DELIMITER)
                .append(value.northeast.latitude)
                .append(DELIMITER)
                .append(value.northeast.longitude)
                .toString();
    }
}
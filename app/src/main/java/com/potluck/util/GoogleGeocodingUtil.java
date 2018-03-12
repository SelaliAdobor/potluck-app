package com.potluck.util;

import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;

import java.util.Arrays;

import java9.util.Optional;

import static java9.util.stream.StreamSupport.stream;

/**
 * Created by selaliadobor on 3/11/18.
 */

public class GoogleGeocodingUtil {
    public static Optional<AddressComponent> findCompontent(GeocodingResult geocodingResult, AddressComponentType type){
        return stream(Arrays.asList(geocodingResult.addressComponents))
                .filter(component -> stream(Arrays.asList(component.types))
                        .anyMatch(addressComponentType -> addressComponentType == type))
                .findFirst();
    }
}

package com.potluck.application;

import android.app.Application;
import android.content.Context;
import android.preference.PreferenceManager;

import com.f2prateek.rx.preferences2.RxSharedPreferences;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.gson.GsonBuilder;
import com.potluck.BuildConfig;
import com.potluck.SharedPreferenceKeys;
import com.potluck.util.AutoValueGsonFactory;
import com.potluck.util.LatLngBoundsSharedPrefConverter;
import com.potluck.util.LatLngSharedPrefConverter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(
                new GsonBuilder().registerTypeAdapterFactory(AutoValueGsonFactory.create())
                        .create());
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.POTLUCK_API_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttp() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> {
            Timber.d(message);
        });
        return new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
    }

    @Provides
    @Singleton
    @LocationObservable
    Observable<LatLngBounds> provideLocationObservable(Application application) {
        return RxSharedPreferences.create(PreferenceManager.getDefaultSharedPreferences(application))
                .getObject(SharedPreferenceKeys.LOCATION, new LatLngBounds(new LatLng(41.3083, 72.9279),new LatLng(41.3083, 72.9279)), LatLngBoundsSharedPrefConverter.INSTANCE)
                .asObservable();
    }
}
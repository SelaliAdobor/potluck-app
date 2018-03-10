package com.potluck.application;

import android.app.Application;
import android.content.Context;

import com.google.gson.GsonBuilder;
import com.potluck.BuildConfig;
import com.potluck.util.AutoValueGsonFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
        return new OkHttpClient.Builder().addInterceptor(chain -> {
            Request request = chain.request();
            Request authenticatedRequest = request.newBuilder()
                    .header("Authorization", Credentials.basic(BuildConfig.POTLUCK_USERNAME, BuildConfig.POTLUCK_PASSWORD)).build();
            return chain.proceed(authenticatedRequest);
        }).build();
    }
}
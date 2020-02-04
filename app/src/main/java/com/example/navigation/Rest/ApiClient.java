package com.example.navigation.Rest;

import android.text.TextUtils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String API_BASE_URL = "http://45.35.169.130/spotapp/spotapp_api/api/";

    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;

    public static Retrofit getClient() {
        if (okHttpClient == null) {
            initOkHttp();
        }
            setRetrofitWithClient();

        return retrofit;
    }

    private static void setRetrofitWithClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    private static void initOkHttp() {
        int REQUEST_TIMEOUT = 90;
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor);
        builder.addInterceptor(chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder()
                    .addHeader("Accept-Charset", " utf-8")
                    .addHeader("Content-Type", " text/xml")
                    .addHeader("Accept", "  application/json");
            requestBuilder.addHeader("Authorization", Authenticator.getAuthToken());
            Request request = requestBuilder.build();
            return chain.proceed(request);
        });
        okHttpClient = builder.build();
    }
}
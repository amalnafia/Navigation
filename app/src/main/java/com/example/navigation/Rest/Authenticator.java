package com.example.navigation.Rest;

import android.annotation.SuppressLint;
import android.util.Base64;

import java.nio.charset.StandardCharsets;

import okhttp3.Interceptor;

public class Authenticator {
    @SuppressLint("NewApi")
    public static String getAuthToken() {
        byte[] data = new byte[0];
        String API_USER_NAME = "spotappwsuser";
        String API_PASSWORD = "spot@1235$";
        data = (API_USER_NAME + ":" + API_PASSWORD).getBytes(StandardCharsets.UTF_8);
        return "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
    }
}
package com.example.hendry.testtopedbrowse.singleton;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Hendry on 2/14/2017.
 */

public class OkHttpSingleton {

    private static OkHttpSingleton ourInstance;
    private OkHttpClient mOkHttpClient;


    public static OkHttpSingleton getInstance() {

        if (ourInstance == null) {
            ourInstance = new OkHttpSingleton();
        }
        return ourInstance;
    }

    private OkHttpSingleton() {

        OkHttpClient.Builder builderOkhttp = new OkHttpClient.Builder();
        builderOkhttp.connectTimeout(40, TimeUnit.SECONDS);
        builderOkhttp.readTimeout(60, TimeUnit.SECONDS);
        builderOkhttp.writeTimeout(60, TimeUnit.SECONDS);
        builderOkhttp.addInterceptor(getInterceptor());

        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builderOkhttp.addInterceptor(logInterceptor);

        mOkHttpClient = builderOkhttp.build();

        setOkHttpClient(mOkHttpClient);
    }

    private Interceptor getInterceptor() {
        return chain -> {
                Response response = chain.proceed(chain.request());
                int count = 0;
                while (!response.isSuccessful() && count < 3) {
                    Log.d("TAG", "Request is not successful - " + count + " Error code : " + response.code());
                    count++;
                    response = chain.proceed(chain.request());
                }
                return response;
            };
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

    public void setOkHttpClient(OkHttpClient okHttpClient) {
        mOkHttpClient = okHttpClient;
    }
}
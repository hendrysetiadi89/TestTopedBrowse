package com.example.hendry.testtopedbrowse.network.service;

import com.example.hendry.testtopedbrowse.network.api.BrowseApi;
import com.example.hendry.testtopedbrowse.network.retrofit.GeneratedHostConverter;
import com.example.hendry.testtopedbrowse.network.retrofit.StringResponseConverter;
import com.example.hendry.testtopedbrowse.network.retrofit.TkpdResponseConverter;
import com.example.hendry.testtopedbrowse.singleton.GsonSingleton;
import com.example.hendry.testtopedbrowse.singleton.OkHttpSingleton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hendry on 2/14/2017.
 */

public class BrowseApiService {
    public BrowseApi api;

    public BrowseApiService(){
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl("https://ace.tokopedia.com/search/")
                .addConverterFactory(new GeneratedHostConverter())
                .addConverterFactory(new TkpdResponseConverter())
                .addConverterFactory(new StringResponseConverter())
                .addConverterFactory(GsonConverterFactory.create(GsonSingleton.getInstance().getGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

        retrofitBuilder.client(OkHttpSingleton.getInstance().getOkHttpClient());
        retrofitBuilder.build();

        api = retrofitBuilder.build().create(BrowseApi.class);
    }

}

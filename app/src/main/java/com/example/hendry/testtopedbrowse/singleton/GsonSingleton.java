package com.example.hendry.testtopedbrowse.singleton;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;

/**
 * Created by Hendry on 2/14/2017.
 */

public class GsonSingleton {
    private static GsonSingleton ourInstance;
    public static GsonSingleton getInstance() {

        if (ourInstance == null) {
            ourInstance = new GsonSingleton();
        }
        return ourInstance;
    }

    private GsonSingleton(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        setGson(gson);
    }

    private Gson mGson;
    public Gson getGson(){
        return mGson;
    }

    public void setGson(Gson mGson) {
        this.mGson = mGson;
    }
}

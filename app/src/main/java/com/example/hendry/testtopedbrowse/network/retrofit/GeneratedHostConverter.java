package com.example.hendry.testtopedbrowse.network.retrofit;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;


/**
 * @author Angga.Prasetiyo on 10/12/2015.
 */
public class GeneratedHostConverter extends Converter.Factory {
    private static final String TAG = GeneratedHostConverter.class.getSimpleName();
    private static final MediaType MEDIA_TYPE = MediaType.parse("text/plain");

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (GeneratedHost.class == type) {
            return new Converter<ResponseBody, GeneratedHost>() {
                @Override
                public GeneratedHost convert(ResponseBody value) throws IOException {
                    String body = value.string();
                    try {
                        JSONObject jsonObject = new JSONObject(body);
                        return new Gson().fromJson(jsonObject
                                .getJSONObject("data")
                                .getJSONObject("generated_host")
                                .toString(), GeneratedHost.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return null;
                    }

                }
            };
        }
        return null;
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        if (String.class == type) {
            return new Converter<String, RequestBody>() {
                @Override
                public RequestBody convert(String value) throws IOException {
                    return RequestBody.create(MEDIA_TYPE, value);
                }
            };
        }
        return null;
    }
}

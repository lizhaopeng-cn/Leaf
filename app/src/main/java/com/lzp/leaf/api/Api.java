package com.lzp.leaf.api;

import com.lzp.leaf.model.MovieModel;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.lzp.leaf.api.ApiConstants.BASE_URL;

/**
 * Created by lzp on 2017/8/8.
 */

public class Api {

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private MovieModel movieModel;

    public static Api newInstance(){
        return new Api();
    }

    private Api(){
        OkHttpClient.Builder client = new OkHttpClient().newBuilder();
        client.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        movieModel = retrofit.create(MovieModel.class);
    }
}

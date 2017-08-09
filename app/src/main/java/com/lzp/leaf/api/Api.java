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

    private static Retrofit retrofit;
    private static ApiService apiService;

    private static void initApi(){
        if(retrofit == null){
            OkHttpClient.Builder client = new OkHttpClient().newBuilder();
            client.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

            retrofit = new Retrofit.Builder()
                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }

    }

    public static ApiService getApiService(){
        initApi();
        return apiService = retrofit.create(ApiService.class);
    }
}

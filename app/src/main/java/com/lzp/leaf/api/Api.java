package com.lzp.leaf.api;

import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.widget.Toast;

import com.lzp.leaf.been.MovieBeen;
import com.lzp.leaf.model.MovieModel;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.lzp.leaf.api.ApiConstants.BASE_URL;

/**
 * Created by lzp on 2017/8/8.
 */

public class Api {

    private static final int DEFAULT_TIMEOUT = 5;

    private static Retrofit retrofit;
    private static ApiService apiService;

    public static ApiService getApiService(){
        initApi();
        apiService = retrofit.create(ApiService.class);
        return apiService;
    }

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

    private static void setSubscribe(Observable observable, RxSubscriber rxSubscriber){
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(rxSubscriber);
    }

    public static void getNetData(String api, RxSubscriber rxSubscriber){
        if(apiService == null){
            getApiService();
        }
        switch (api){
            case ApiConstants.IN_THEATERS:
                Observable<MovieBeen> observableInTheaters = apiService.getInTheaters();
                setSubscribe(observableInTheaters, rxSubscriber);
                break;
            case ApiConstants.COMING_SOON:
                Observable<MovieBeen> observableComingSoon = apiService.getComingSoon();
                setSubscribe(observableComingSoon, rxSubscriber);
                break;
            case ApiConstants.TOP_250:
                Observable<MovieBeen> observableTop250 = apiService.getTop250(0,100);
                setSubscribe(observableTop250, rxSubscriber);
                break;
            default:
                break;
        }
    }
}

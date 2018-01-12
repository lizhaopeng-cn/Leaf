package com.lzp.leaf.api;

import android.util.Log;

import com.lzp.leaf.been.movie.MovieBeen;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
        if(retrofit == null){
            initApi();
        }
        return apiService;
    }

    private static void initApi(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //打印retrofit日志
                Log.i("RetrofitLog","retrofitBack = "+message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient()
                .newBuilder().addInterceptor(loggingInterceptor)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static void setSubscribe(Observable observable, RxSubscriber rxSubscriber){
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(rxSubscriber);
    }

//    public static void getNetData(String api, RxSubscriber rxSubscriber){
//        if(apiService == null){
//            getApiService();
//        }
//        switch (api){
//            case ApiConstants.IN_THEATERS:
//                Observable<MovieBeen> observableInTheaters = apiService.getInTheaters();
//                setSubscribe(observableInTheaters, rxSubscriber);
//                break;
//            case ApiConstants.COMING_SOON:
//                Observable<MovieBeen> observableComingSoon = apiService.getComingSoon();
//                setSubscribe(observableComingSoon, rxSubscriber);
//                break;
//            case ApiConstants.TOP_250:
//                Observable<MovieBeen> observableTop250 = apiService.getTop250(0,100);
//                setSubscribe(observableTop250, rxSubscriber);
//                break;
//            default:
//                break;
//        }
//    }
}

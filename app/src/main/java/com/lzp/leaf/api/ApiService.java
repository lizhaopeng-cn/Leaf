package com.lzp.leaf.api;

import com.lzp.leaf.been.MovieBeen;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lzp on 2017/8/8.
 */

public interface ApiService {

    @GET(ApiConstants.IN_THEATERS)
    Observable<MovieBeen> getInTheaters();

    @GET(ApiConstants.COMING_SOON)
    Observable<MovieBeen> getComingSoon();

    @GET(ApiConstants.TOP_250)
    Observable<MovieBeen> getTop250(@Query("start") int start, @Query("count") int count);
}

package com.lzp.movie.api;

import com.lzp.movie.been.MovieBeen;
import com.lzp.movie.been.MovieCelebrityBeen;
import com.lzp.movie.been.MovieSubjectsBeen;

import api.ApiConstants;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lzp48947 on 2018/4/16.
 */

public interface ApiService {
    @GET(ApiConstants.MOVIE + ApiConstants.IN_THEATERS)
    Observable<MovieBeen> getInTheaters();

    @GET(ApiConstants.MOVIE + ApiConstants.COMING_SOON)
    Observable<MovieBeen> getComingSoon();

    @GET(ApiConstants.MOVIE + ApiConstants.TOP_250)
    Observable<MovieBeen> getTop250(@Query("start") int start, @Query("count") int count);

    @GET(ApiConstants.MOVIE + ApiConstants.SUBJECT + "/" + "{subjectId}")
    Observable<MovieSubjectsBeen> getSubject(@Path("subjectId") String subjectId);

    @GET(ApiConstants.MOVIE + ApiConstants.CELEBRITY + "/" + "{celebrityId}")
    Observable<MovieCelebrityBeen> getCelebrity(@Path("celebrityId") String celebrityId);
}

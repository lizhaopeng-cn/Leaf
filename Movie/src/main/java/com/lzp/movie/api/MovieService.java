package com.lzp.movie.api;

import com.lzp.movie.been.MovieBeen;
import com.lzp.movie.been.MovieCelebrityBeen;
import com.lzp.movie.been.MovieSubjectsBeen;

import com.lzp.basemodule.api.BaseConstants;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lzp48947 on 2018/4/16.
 */

public interface MovieService {
    @GET(MovieConstants.MOVIE + MovieConstants.IN_THEATERS)
    Observable<MovieBeen> getInTheaters();

    @GET(MovieConstants.MOVIE + MovieConstants.COMING_SOON)
    Observable<MovieBeen> getComingSoon();

    @GET(MovieConstants.MOVIE + MovieConstants.TOP_250)
    Observable<MovieBeen> getTop250(@Query("start") int start, @Query("count") int count);

    @GET(MovieConstants.MOVIE + MovieConstants.SUBJECT + "/" + "{subjectId}")
    Observable<MovieSubjectsBeen> getSubject(@Path("subjectId") String subjectId);

    @GET(MovieConstants.MOVIE + MovieConstants.CELEBRITY + "/" + "{celebrityId}")
    Observable<MovieCelebrityBeen> getCelebrity(@Path("celebrityId") String celebrityId);
}

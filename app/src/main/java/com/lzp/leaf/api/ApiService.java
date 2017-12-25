package com.lzp.leaf.api;

import com.lzp.leaf.been.movie.MovieBeen;
import com.lzp.leaf.been.movie.MovieCelebrity;
import com.lzp.leaf.been.movie.MovieSubjectsBeen;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lzp on 2017/8/8.
 */

public interface ApiService {

    @GET(ApiConstants.Movie + ApiConstants.IN_THEATERS)
    Observable<MovieBeen> getInTheaters();

    @GET(ApiConstants.Movie + ApiConstants.COMING_SOON)
    Observable<MovieBeen> getComingSoon();

    @GET(ApiConstants.Movie + ApiConstants.TOP_250)
    Observable<MovieBeen> getTop250(@Query("start") int start, @Query("count") int count);

    @GET(ApiConstants.Movie + ApiConstants.SUBJECT + "/" + "{subjectId}")
    Observable<MovieSubjectsBeen> getSubject(@Path("subjectId") String subjectId);

    @GET(ApiConstants.Movie + ApiConstants.CELEBRITY + "/" + "{celebrityId}")
    Observable<MovieCelebrity> getCelebrity(@Path("celebrityId") String celebrityId);
}

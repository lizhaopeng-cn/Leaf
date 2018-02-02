package com.lzp.leaf.api;

import com.lzp.leaf.been.book.BookBeen;
import com.lzp.leaf.been.movie.MovieBeen;
import com.lzp.leaf.been.movie.MovieCelebrityBeen;
import com.lzp.leaf.been.movie.MovieSubjectsBeen;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lzp on 2017/8/8.
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

    @GET(ApiConstants.BOOK + ApiConstants.SEARCH)
    Observable<BookBeen> getBooks(@Query("q") String keyword);
}

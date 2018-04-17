package com.example.book.api;

import com.example.book.been.BookBeen;

import api.ApiConstants;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lzp48947 on 2018/4/16.
 */

public interface ApiService {
    @GET(ApiConstants.BOOK + ApiConstants.SEARCH)
    Observable<BookBeen> getBooks(@Query("q") String keyword);
}

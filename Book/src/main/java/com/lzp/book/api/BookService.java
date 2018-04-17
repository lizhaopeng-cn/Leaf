package com.lzp.book.api;

import com.lzp.book.been.BookBeen;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lzp48947 on 2018/4/16.
 */

public interface BookService {
    @GET(BookConstants.BOOK + BookConstants.SEARCH)
    Observable<BookBeen> getBooks(@Query("q") String keyword);
}

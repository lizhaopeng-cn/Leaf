package com.lzp.book.model;

import com.lzp.basemodule.api.Api;
import com.lzp.basemodule.api.RxSubscriber;
import com.lzp.book.api.BookService;
import com.lzp.book.been.BookBeen;
import com.lzp.book.contract.IBookContract;
import com.lzp.book.presenter.BookPresenter;

import rx.Observable;

/**
 * Created by lzp48947 on 2018/4/18.
 */

public class BookModel implements IBookContract.IBookModel{
    private BookPresenter bookPresenter;
    private String keyword;

    public BookModel(BookPresenter bookPresenter){
        this.bookPresenter = bookPresenter;
    }

    @Override
    public void getBookData(RxSubscriber<BookBeen> rxSubscriber) {
        BookService bookService = Api.getApiService().create(BookService.class);
        Observable<BookBeen> observableBooks = bookService.getBooks(keyword);
        Api.setSubscribe(observableBooks, rxSubscriber);
    }

    @Override
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}

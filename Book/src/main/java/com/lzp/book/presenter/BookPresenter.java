package com.lzp.book.presenter;


import com.lzp.book.been.BookBeen;
import com.lzp.book.contract.IBookContract;
import com.lzp.book.model.BookModel;

/**
 * Created by lzp48947 on 2018/4/18.
 */

public class BookPresenter implements IBookContract.IBookPresenter{
    private IBookContract.IBookView bookView;

    public BookPresenter(IBookContract.IBookView bookView){
        this.bookView = bookView;
    }

    @Override
    public void goBookModelData(String etKeyword) {
        BookModel bookModel = new BookModel(this);
        bookModel.getBookData(etKeyword);
    }

    @Override
    public void updateBookView(BookBeen bookBeen) {
        bookView.toSearch(bookBeen);
    }
}

package com.lzp.book.presenter;


import com.lzp.basemodule.api.RxSubscriber;
import com.lzp.basemodule.base.BasePresenter;
import com.lzp.book.api.BookConstants;
import com.lzp.book.been.BookBeen;
import com.lzp.book.contract.IBookContract;
import com.lzp.book.fragment.BookFragment;
import com.lzp.book.model.BookModel;

/**
 * Created by lzp48947 on 2018/4/18.
 */

public class BookPresenter extends BasePresenter implements IBookContract.IBookPresenter{
    private IBookContract.IBookView bookView;

    @Override
    public void goBookModelData() {
        bookView = (IBookContract.IBookView)getView();
        BookModel bookModel = new BookModel(this);
        bookModel.setKeyword(bookView.getKeyword());
        bookView.showLoading();
        bookModel.getBookData(new RxSubscriber<BookBeen>() {
            @Override
            public void onNext(BookBeen bookBeen) {
                bookView.toSearch(bookBeen);
                bookView.hideLoading();
            }
        });

    }
}

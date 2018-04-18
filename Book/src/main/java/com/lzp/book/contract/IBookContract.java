package com.lzp.book.contract;

import com.lzp.book.been.BookBeen;

/**
 * Created by lzp48947 on 2018/4/18.
 */

public interface IBookContract {
    interface IBookView{
        void toSearch(BookBeen bookBeen);
    }
    interface IBookModel{
        void getBookData(String etKeyword);
    }
    interface IBookPresenter{
        void goBookModelData(String etKeyword);
        void updateBookView(BookBeen bookBeen);
    }
}

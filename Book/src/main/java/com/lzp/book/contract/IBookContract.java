package com.lzp.book.contract;

import com.lzp.basemodule.api.RxSubscriber;
import com.lzp.basemodule.base.BasePresenter;
import com.lzp.basemodule.base.IBaseModel;
import com.lzp.basemodule.base.IBasePresenter;
import com.lzp.basemodule.base.IBaseView;
import com.lzp.book.been.BookBeen;
import com.lzp.book.fragment.BookFragment;
import com.lzp.book.model.BookModel;

/**
 * Created by lzp48947 on 2018/4/18.
 */

public interface IBookContract {
    interface IBookView extends IBaseView{
        void toSearch(BookBeen bookBeen);
        String getKeyword();
    }
    interface IBookModel extends IBaseModel {
        void getBookData(RxSubscriber<BookBeen> rxSubscriber);
        void setKeyword(String keyword);
    }
    interface IBookPresenter extends IBasePresenter{
        void goBookModelData();
//        void updateBookView(BookBeen bookBeen);
    }
}

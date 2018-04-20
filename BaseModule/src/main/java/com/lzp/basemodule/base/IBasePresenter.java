package com.lzp.basemodule.base;

/**
 * Created by lzp48947 on 2018/4/20.
 */

public interface IBasePresenter {
    void attachView(IBaseView view);
    void detachView();
    boolean isViewAttached();
    IBaseView getView();
}

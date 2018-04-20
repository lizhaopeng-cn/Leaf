package com.lzp.basemodule.base;

/**
 * Created by lzp on 2017/8/8.
 */

public class BasePresenter implements IBasePresenter{
    private IBaseView view;

    @Override
    public void attachView(IBaseView view) {
        this.view = view;
    }

    @Override
    public void detachView(){
        view = null;
    }

    @Override
    public boolean isViewAttached(){
        return view != null;
    }

    @Override
    public IBaseView getView(){
        return view;
    }
}

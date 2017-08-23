package com.lzp.leaf.api;


import rx.Subscriber;

/**
 * Created by lzp on 2017/8/16.
 */

public abstract class RxSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted(){

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

}

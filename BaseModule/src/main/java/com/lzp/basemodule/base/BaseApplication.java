package com.lzp.basemodule.base;


import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.DaggerAppCompatActivity;
import dagger.android.support.DaggerApplication;


/**
 * Created by lzp on 2017/8/8.
 */

public class BaseApplication extends DaggerApplication {
//    @Inject
//    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
////        DaggerAppComponent.builder().application(this).build().inject(this);
//    }
//
//    @Override
//    public AndroidInjector<Activity> activityInjector() {
//        return activityDispatchingAndroidInjector;
//    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return null;
    }
}

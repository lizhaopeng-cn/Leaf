package com.lzp.basemodule.base;


import dagger.android.AndroidInjector;
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
    protected AndroidInjector<? extends BaseApplication> applicationInjector() {
        return null;
    }
}

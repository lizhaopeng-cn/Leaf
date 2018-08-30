package com.lzp.leaf;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by lzp48947 on 2018/8/30.
 */
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class
})
public interface AppComponent extends AndroidInjector<MyApplication> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<MyApplication>{}
}

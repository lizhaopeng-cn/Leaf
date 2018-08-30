package com.lzp.leaf;

import com.lzp.movie.di.MovieFragmentBuilder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by lzp48947 on 2018/8/30.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MainActivityModule.class, MovieFragmentBuilder.class})
    abstract MainActivity bindMainActivity();
}

package com.lzp.movie.di;

import com.lzp.movie.activity.MovieDetailActivity;
import com.lzp.movie.di.module.MovieModule;
import com.lzp.movie.di.module.MovieTypeModule;
import com.lzp.movie.di.module.MovieDetailModule;
import com.lzp.movie.fragment.MovieFragment;
import com.lzp.movie.fragment.MovieTypeFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by lzp48947 on 2018/8/30.
 */
@Module
public abstract class MovieFragmentBuilder {

    @ContributesAndroidInjector(modules = {MovieModule.class, MovieTypeFragmentBuilder.class})
    abstract MovieFragment bindMovieFragment();




}

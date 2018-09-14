package com.lzp.movie.di;

import com.lzp.movie.di.module.MovieTypeModule;
import com.lzp.movie.fragment.MovieTypeFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by lzp48947 on 2018/9/14.
 */
@Module
public abstract class MovieTypeFragmentBuilder {
    @ContributesAndroidInjector(modules = MovieTypeModule.class)
    abstract MovieTypeFragment bindMovieTypeFragment();
}

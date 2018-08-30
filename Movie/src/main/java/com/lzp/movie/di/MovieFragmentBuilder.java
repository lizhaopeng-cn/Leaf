package com.lzp.movie.di;

import com.lzp.movie.di.movie_fragment.MovieModule;
import com.lzp.movie.di.movie_item_fragment.MovieTypeModule;
import com.lzp.movie.di.movie_detail_activity.MovieDetailModule;
import com.lzp.movie.fragment.MovieFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by lzp48947 on 2018/8/30.
 */
@Module
public abstract class MovieFragmentBuilder {

    @ContributesAndroidInjector(modules = {MovieModule.class, MovieTypeModule.class, MovieDetailModule.class})
    abstract MovieFragment bindMovieFragment();
}

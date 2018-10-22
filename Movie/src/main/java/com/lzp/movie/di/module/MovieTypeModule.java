package com.lzp.movie.di.module;

import android.app.Activity;
import android.content.Context;

import com.lzp.movie.adapter.MovieAdapter;
import com.lzp.movie.been.MovieBeen;
import com.lzp.movie.model.MovieModel;
import com.lzp.movie.presenter.MoviePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lzp48947 on 2018/8/29.
 */
@Module
public class MovieTypeModule {
    @Provides
    public MoviePresenter provideMoviePresenter(){
        return new MoviePresenter();
    }

    @Provides
    public MovieAdapter provideMovieAdapter(Activity activity, MovieBeen movieBeen){
        return new MovieAdapter(activity, movieBeen);
    }

//    @Provides
//    public MovieModel provideMovieModel(MoviePresenter moviePresenter){
//        return new MovieModel(moviePresenter);
//    }
}

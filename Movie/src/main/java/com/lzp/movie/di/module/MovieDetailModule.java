package com.lzp.movie.di.module;

import android.content.Context;

import com.lzp.movie.adapter.MovieAdapter;
import com.lzp.movie.been.MovieBeen;
import com.lzp.movie.model.MovieDetailModel;
import com.lzp.movie.model.MovieModel;
import com.lzp.movie.presenter.MovieDetailPresenter;
import com.lzp.movie.presenter.MoviePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lzp48947 on 2018/8/30.
 */
@Module
public class MovieDetailModule {
    @Provides
    public MovieDetailPresenter provideMovieDetailPresenter(){
        return new MovieDetailPresenter();
    }

//    @Provides
//    public MovieDetailModel provideMovieDetailModel(MovieDetailPresenter movieDetailPresenter){
//        return new MovieDetailModel(movieDetailPresenter);
//    }
}

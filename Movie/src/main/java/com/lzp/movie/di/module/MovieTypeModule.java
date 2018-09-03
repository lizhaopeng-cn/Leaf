package com.lzp.movie.di.module;

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
    public MovieAdapter provideMovieAdapter(Context context, MovieBeen movieBeen){
        return new MovieAdapter(context, movieBeen);
    }

//    @Provides
//    public MovieModel provideMovieModel(MoviePresenter moviePresenter){
//        return new MovieModel(moviePresenter);
//    }
}

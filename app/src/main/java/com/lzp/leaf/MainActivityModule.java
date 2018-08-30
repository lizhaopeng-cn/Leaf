package com.lzp.leaf;

import com.lzp.movie.fragment.MovieFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lzp48947 on 2018/8/30.
 */
@Module
public class MainActivityModule {
    @Provides
    public MovieFragment provideMovieFragment(){
        return new MovieFragment();
    }

//    @Provides
//    public BookFragment provideBookFragment(){
//        return new BookFragment();
//    }
}

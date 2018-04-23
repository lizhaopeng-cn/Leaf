package com.lzp.movie.presenter;

import com.lzp.basemodule.api.RxSubscriber;
import com.lzp.basemodule.base.BasePresenter;
import com.lzp.movie.been.MovieBeen;
import com.lzp.movie.contract.MovieContract;
import com.lzp.movie.model.MovieModel;

/**
 * Created by lzp48947 on 2018/4/23.
 */

public class MoviePresenter extends BasePresenter implements MovieContract.IMoviePersenter {
    private MovieContract.IMovieView movieView;
    public MoviePresenter(MovieContract.IMovieView movieView){
        this.movieView = movieView;
    }

    @Override
    public void goMovieModelData() {
        MovieModel movieModel = new MovieModel(this);
        String type = movieView.getMovieType();
        movieModel.setMovieType(type);
        movieView.showLoading();
        movieModel.getMovieData(new RxSubscriber<MovieBeen>() {
            @Override
            public void onNext(MovieBeen movieBeen) {
                movieView.initRecycler(movieBeen);
                movieView.hideLoading();
            }
        });
    }
}

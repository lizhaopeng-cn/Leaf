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

    @Override
    public void goMovieModelData() {
        movieView = (MovieContract.IMovieView)getView();
        MovieModel movieModel = new MovieModel(this);
        String type = movieView.getMovieType();
        movieModel.setMovieType(type);
        movieView.showLoading();
        movieModel.getMovieData(new RxSubscriber<MovieBeen>() {
            @Override
            public void onNext(MovieBeen movieBeen) {
                if(isViewAttached()){
                    movieView.initRecycler(movieBeen);
                    movieView.hideLoading();
                }
            }
        });
    }
}

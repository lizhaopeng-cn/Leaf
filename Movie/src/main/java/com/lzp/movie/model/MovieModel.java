package com.lzp.movie.model;


import com.lzp.basemodule.api.Api;
import com.lzp.basemodule.api.RxSubscriber;
import com.lzp.basemodule.base.BaseModel;
import com.lzp.movie.api.MovieConstants;
import com.lzp.movie.api.MovieService;
import com.lzp.movie.been.MovieBeen;
import com.lzp.movie.contract.MovieContract;
import com.lzp.movie.presenter.MoviePresenter;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by lzp on 2017/8/1.
 */

public class MovieModel extends BaseModel implements MovieContract.IMovieModel {
//    @Inject
    MoviePresenter moviePresenter;
    private String type;
    public MovieModel(MoviePresenter moviePresenter){
        this.moviePresenter = moviePresenter;
    }

    @Override
    public void getMovieData(RxSubscriber<MovieBeen> rxSubscriber) {
        MovieService movieService = Api.getApiService().create(MovieService.class);
        switch (type){
            case MovieConstants.IN_THEATERS:
                Observable<MovieBeen> observableInTheaters = movieService.getInTheaters();
                Api.setSubscribe(observableInTheaters, rxSubscriber);
                break;
            case MovieConstants.COMING_SOON:
                Observable<MovieBeen> observableComingSoon = movieService.getComingSoon();
                Api.setSubscribe(observableComingSoon, rxSubscriber);
                break;
            case MovieConstants.TOP_250:
                Observable<MovieBeen> observableTop250 = movieService.getTop250(0,100);
                Api.setSubscribe(observableTop250, rxSubscriber);
                break;
            default:
                break;
        }
    }

    @Override
    public void setMovieType(String type) {
        this.type = type;
    }
}

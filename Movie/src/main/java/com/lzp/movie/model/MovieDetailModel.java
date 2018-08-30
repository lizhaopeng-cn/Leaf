package com.lzp.movie.model;

import com.lzp.basemodule.api.Api;
import com.lzp.basemodule.api.RxSubscriber;
import com.lzp.basemodule.base.BaseModel;
import com.lzp.movie.api.MovieService;
import com.lzp.movie.been.MovieSubjectsBeen;
import com.lzp.movie.contract.MovieDetailContract;
import com.lzp.movie.presenter.MovieDetailPresenter;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by lzp48947 on 2018/4/23.
 */

public class MovieDetailModel extends BaseModel implements MovieDetailContract.IMovieDetailModel {
//    @Inject
    MovieDetailPresenter movieDetailPresenter;
    private String subjectId;

    public MovieDetailModel(MovieDetailPresenter movieDetailPresenter){
        this.movieDetailPresenter = movieDetailPresenter;
    }

    @Override
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public void getMovieDetailData(RxSubscriber<MovieSubjectsBeen> rxSubscriber) {
        Observable<MovieSubjectsBeen> observableSubject = Api.getApiService().create(MovieService.class).getSubject(subjectId);
        Api.setSubscribe(observableSubject, rxSubscriber);
    }

}

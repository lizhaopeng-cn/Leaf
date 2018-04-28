package com.lzp.movie.presenter;

import com.lzp.basemodule.api.RxSubscriber;
import com.lzp.basemodule.base.BasePresenter;
import com.lzp.movie.been.MovieSubjectsBeen;
import com.lzp.movie.contract.MovieDetailContract;
import com.lzp.movie.model.MovieDetailModel;

/**
 * Created by lzp48947 on 2018/4/23.
 */

public class MovieDetailPresenter extends BasePresenter implements MovieDetailContract.IMovieDetailPresenter{
    private MovieDetailContract.IMovieDetailView movieDetailView;


    @Override
    public void goMovieDetailModelData() {
        movieDetailView = (MovieDetailContract.IMovieDetailView)getView();
        MovieDetailModel movieDetailModel = new MovieDetailModel(this);
        String subjectId = movieDetailView.getSubjectId();
        movieDetailModel.setSubjectId(subjectId);
        movieDetailModel.getMovieDetailData(new RxSubscriber<MovieSubjectsBeen>() {
            @Override
            public void onNext(MovieSubjectsBeen movieSubjectsBeen) {
                if(isViewAttached()){
                    movieDetailView.setView(movieSubjectsBeen);
                }
            }
        });
    }
}

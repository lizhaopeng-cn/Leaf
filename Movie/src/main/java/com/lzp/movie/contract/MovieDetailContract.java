package com.lzp.movie.contract;

import com.lzp.basemodule.api.RxSubscriber;
import com.lzp.basemodule.base.IBaseModel;
import com.lzp.basemodule.base.IBasePresenter;
import com.lzp.basemodule.base.IBaseView;
import com.lzp.movie.been.MovieSubjectsBeen;

/**
 * Created by lzp48947 on 2018/4/23.
 */

public interface MovieDetailContract {
    interface IMovieDetailModel extends IBaseModel{
        void getMovieDetailData(RxSubscriber<MovieSubjectsBeen> rxSubscriber);
        void setSubjectId(String subjectId);
    }
    interface IMovieDetailPresenter extends IBasePresenter{
        void goMovieDetailModelData();
    }
    interface IMovieDetailView extends IBaseView{
        void setView(MovieSubjectsBeen movieSubjectsBeen);
        String getSubjectId();
    }
}

package com.lzp.movie.contract;

import com.lzp.basemodule.api.RxSubscriber;
import com.lzp.basemodule.base.IBaseModel;
import com.lzp.basemodule.base.IBasePresenter;
import com.lzp.basemodule.base.IBaseView;
import com.lzp.movie.been.MovieBeen;

/**
 * Created by lzp on 2017/8/8.
 */

public interface MovieContract {
    interface IMovieModel extends IBaseModel{
        void getMovieData(RxSubscriber<MovieBeen> rxSubscriber);
        void setMovieType(String type);
    }
    interface IMoviePersenter extends IBasePresenter{
        void goMovieModelData();
    }
    interface IMovieView extends IBaseView{
        String getMovieType();
        void initRecycler(MovieBeen movieBeen);
    }
}

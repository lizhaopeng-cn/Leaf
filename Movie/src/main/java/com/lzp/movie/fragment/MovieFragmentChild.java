package com.lzp.movie.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzp.basemodule.base.BaseFragment;
import com.lzp.movie.R;
import com.lzp.movie.R2;
import com.lzp.movie.adapter.MovieAdapter;
import com.lzp.movie.api.MovieConstants;
import com.lzp.movie.api.MovieService;
import com.lzp.movie.been.MovieBeen;

import com.lzp.basemodule.api.Api;
import com.lzp.basemodule.api.BaseConstants;
import com.lzp.basemodule.api.RxSubscriber;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

/**
 * Created by lzp on 2017/8/8.
 */

public class MovieFragmentChild extends BaseFragment {

    @BindView(R2.id.rv_movie)
    RecyclerView rvMovie;

    private View view;

    private MovieAdapter movieAdapter;

    private String type;

    public static MovieFragmentChild newInstance(String type) {

        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        MovieFragmentChild fragment = new MovieFragmentChild();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_movie;
    }

    @Override
    public void init() {
        type = getArguments().getString("type");
        MovieService movieService = Api.getApiService().create(MovieService.class);

        getNetData(movieService, type, new RxSubscriber<MovieBeen>() {
            @Override
            public void onNext(MovieBeen movieBeen) {
                initRecycler(movieBeen);
            }
        });
    }

    public void getNetData(MovieService movieService, String api, RxSubscriber rxSubscriber){
        switch (api){
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


    private void initRecycler(MovieBeen movieBeen) {
        movieAdapter = new MovieAdapter(getActivity(),movieBeen);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(position == 0){
                    return 2;
                }else{
                    return 1;
                }
            }
        });
        rvMovie.setLayoutManager(gridLayoutManager);
//        rvMovie.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
//        rvMovie.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
        rvMovie.setAdapter(movieAdapter);
    }
}

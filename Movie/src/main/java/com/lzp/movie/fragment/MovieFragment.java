package com.lzp.movie.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lzp.basemodule.base.BaseFragment;
import com.lzp.movie.R;
import com.lzp.movie.R2;
import com.lzp.movie.adapter.MovieAdapter;
import com.lzp.movie.been.MovieBeen;
import com.lzp.movie.contract.MovieContract;
import com.lzp.movie.presenter.MoviePresenter;

import butterknife.BindView;

/**
 * Created by lzp on 2017/8/8.
 */

public class MovieFragment extends BaseFragment implements MovieContract.IMovieView{

    @BindView(R2.id.rv_movie)
    RecyclerView rvMovie;

    private MovieAdapter movieAdapter;

    private String type;

    public static MovieFragment newInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        MovieFragment fragment = new MovieFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void init() {
        MoviePresenter moviePresenter = new MoviePresenter(this);
        type = getArguments().getString("type");
        moviePresenter.goMovieModelData();
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_movie;
    }

    @Override
    public String getMovieType() {
        return type;
    }

    @Override
    public void initRecycler(MovieBeen movieBeen) {
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

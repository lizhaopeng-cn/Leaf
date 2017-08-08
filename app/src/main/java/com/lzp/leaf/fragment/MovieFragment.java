package com.lzp.leaf.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzp.leaf.R;
import com.lzp.leaf.base.BaseFragment;
import com.lzp.leaf.been.MovieBeen;

import butterknife.BindView;
import rx.Observable;

/**
 * Created by lzp on 2017/8/8.
 */

public class MovieFragment extends BaseFragment {

    @BindView(R.id.rv_movie) RecyclerView rvMovie;

    private View view;

    public static MovieFragment newInstance(String status) {

        Bundle bundle = new Bundle();
        bundle.putString("status", status);
        MovieFragment fragment = new MovieFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_movie,container,false);
        getMovieDatas();
        initRecycler();
        return view;
    }

    private void getMovieDatas() {
        Observable<MovieBeen>
    }

    private void initRecycler() {
    }
}

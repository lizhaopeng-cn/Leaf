package com.lzp.leaf.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lzp.leaf.R;
import com.lzp.leaf.adapter.MovieAdapter;
import com.lzp.leaf.api.Api;
import com.lzp.leaf.base.BaseFragment;
import com.lzp.leaf.been.MovieBeen;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lzp on 2017/8/8.
 */

public class MovieFragment extends BaseFragment {

//    @BindView(R.id.rv_movie)
    RecyclerView rvMovie;

    private View view;

    private MovieAdapter movieAdapter;

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
//        ButterKnife.bind(getActivity(), view);
        rvMovie = (RecyclerView) view.findViewById(R.id.rv_movie);
        getMovieDatas();
        initRecycler();
        return view;
    }

    private void getMovieDatas() {
        Api.getApiService()
                .getInTheaters()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieBeen>() {
                    @Override
                    public void onCompleted() {
                        Log.i("log","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("log","onError");
                    }

                    @Override
                    public void onNext(MovieBeen movieBeen) {
                        Log.i("log","onNext");
                        movieAdapter = new MovieAdapter(getActivity(),movieBeen);
                        rvMovie.setLayoutManager(new GridLayoutManager(getActivity(), 3));
//                        rvMovie.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
//                        rvMovie.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
                        rvMovie.setAdapter(movieAdapter);
                    }
                });
    }

    private void initRecycler() {
    }
}

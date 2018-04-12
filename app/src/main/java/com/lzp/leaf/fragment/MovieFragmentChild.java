package com.lzp.leaf.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzp.leaf.R;
import com.lzp.leaf.adapter.MovieAdapter;
import com.lzp.leaf.api.Api;
import com.lzp.leaf.api.ApiConstants;
import com.lzp.leaf.api.ApiService;
import com.lzp.leaf.api.RxSubscriber;
import com.lzp.leaf.base.BaseFragment;
import com.lzp.leaf.been.movie.MovieBeen;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

/**
 * Created by lzp on 2017/8/8.
 */

public class MovieFragmentChild extends BaseFragment {

    @BindView(R.id.rv_movie)
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_movie,container,false);
        ButterKnife.bind(this, view);
        rvMovie = (RecyclerView) view.findViewById(R.id.rv_movie);
        type = getArguments().getString("type");
        ApiService apiService = Api.getApiService();

        getNetData(apiService, type, new RxSubscriber<MovieBeen>() {
            @Override
            public void onNext(MovieBeen movieBeen) {
                initRecycler(movieBeen);
            }
        });
        return view;
    }

    public void getNetData(ApiService apiService, String api, RxSubscriber rxSubscriber){
        switch (api){
            case ApiConstants.IN_THEATERS:
                Observable<MovieBeen> observableInTheaters = apiService.getInTheaters();
                Api.setSubscribe(observableInTheaters, rxSubscriber);
                break;
            case ApiConstants.COMING_SOON:
                Observable<MovieBeen> observableComingSoon = apiService.getComingSoon();
                Api.setSubscribe(observableComingSoon, rxSubscriber);
                break;
            case ApiConstants.TOP_250:
                Observable<MovieBeen> observableTop250 = apiService.getTop250(0,100);
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

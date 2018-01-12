package com.lzp.leaf.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lzp.leaf.R;
import com.lzp.leaf.api.Api;
import com.lzp.leaf.api.RxSubscriber;
import com.lzp.leaf.base.BaseActivity;
import com.lzp.leaf.been.movie.MovieSubjectsBeen;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

/**
 * Created by lzp48947 on 2017/12/25.
 */

public class MovieDetailActivity extends BaseActivity {

    @BindView(R.id.image)
    ImageView image;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //左上角返回箭头的监听
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String subjectId = getIntent().getStringExtra("subjectId");
        Observable<MovieSubjectsBeen> observableSubject = Api.getApiService().getSubject(subjectId);
        Api.setSubscribe(observableSubject, new RxSubscriber<MovieSubjectsBeen>() {
            @Override
            public void onNext(MovieSubjectsBeen movieSubjectsBeen) {
//                collapsingToolbarLayout.setStatusBarScrim(getDrawable(R.mipmap.ic_launcher));
                collapsingToolbarLayout.setTitle(movieSubjectsBeen.getTitle());
                Glide.with(MovieDetailActivity.this).load(movieSubjectsBeen.getImages().getSmall()).into(image);
            }
        });
    }
}

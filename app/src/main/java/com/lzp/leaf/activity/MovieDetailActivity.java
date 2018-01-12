package com.lzp.leaf.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lzp.leaf.R;
import com.lzp.leaf.api.Api;
import com.lzp.leaf.api.ApiConstants;
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

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.image)
    ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        String subjectId = getIntent().getStringExtra("subjectId");
        Observable<MovieSubjectsBeen> observableSubject = Api.getApiService().getSubject(subjectId);
        Api.setSubscribe(observableSubject, new RxSubscriber<MovieSubjectsBeen>() {
            @Override
            public void onNext(MovieSubjectsBeen movieSubjectsBeen) {
                title.setText(movieSubjectsBeen.getTitle());
                Glide.with(MovieDetailActivity.this).load(movieSubjectsBeen.getImages().getSmall()).into(image);
            }
        });
    }
}

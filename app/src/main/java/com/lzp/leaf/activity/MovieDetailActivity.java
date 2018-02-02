package com.lzp.leaf.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

    @BindView(R.id.tv_id)
    TextView tvID;

    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.tv_original_title)
    TextView tv_original_title;

    @BindView(R.id.tv_aka)
    TextView tv_aka;

    @BindView(R.id.tv_alt)
    TextView tv_alt;

    @BindView(R.id.tv_mobile_url)
    TextView tv_mobile_url;

    @BindView(R.id.tv_ratings_count)
    TextView tv_ratings_count;

    @BindView(R.id.tv_wish_count)
    TextView tv_wish_count;

    @BindView(R.id.tv_collect_count)
    TextView tv_collect_count;

    @BindView(R.id.tv_do_count)
    TextView tv_do_count;

    @BindView(R.id.tv_subtype)
    TextView tv_subtype;

    @BindView(R.id.tv_website)
    TextView tv_website;

    @BindView(R.id.tv_douban_site)
    TextView tv_douban_site;

    @BindView(R.id.tv_pubdates)
    TextView tv_pubdates;

    @BindView(R.id.tv_mainland_pubdate)
    TextView tv_mainland_pubdate;

    @BindView(R.id.tv_pubdate)
    TextView tv_pubdate;

    @BindView(R.id.tv_year)
    TextView tv_year;

    @BindView(R.id.tv_languages)
    TextView tv_languages;

    @BindView(R.id.tv_durations)
    TextView tv_durations;

    @BindView(R.id.tv_genres)
    TextView tv_genres;

    @BindView(R.id.tv_countries)
    TextView tv_countries;

    @BindView(R.id.tv_summary)
    TextView tv_summary;

    @BindView(R.id.tv_comments_count)
    TextView tv_comments_count;

    @BindView(R.id.tv_reviews_count)
    TextView tv_reviews_count;

    @BindView(R.id.tv_seasons_count)
    TextView tv_seasons_count;

    @BindView(R.id.tv_current_season)
    TextView tv_current_season;

    @BindView(R.id.tv_episodes_count)
    TextView tv_episodes_count;

    @BindView(R.id.tv_schedule_url)
    TextView tv_schedule_url;

    @BindView(R.id.tv_trailer_urls)
    TextView tv_trailer_urls;

    @BindView(R.id.tv_clip_urls)
    TextView tv_clip_urls;

    @BindView(R.id.tv_blooper_urls)
    TextView tv_blooper_urls;

    @BindView(R.id.tv_photos)
    TextView tv_photos;

    @BindView(R.id.tv_popular_reviews)
    TextView tv_popular_reviews;

    @BindView(R.id.tv_rating_min)
    TextView tv_rating_min;

    @BindView(R.id.tv_rating_max)
    TextView tv_rating_max;

    @BindView(R.id.tv_rating_average)
    TextView tv_rating_average;

    @BindView(R.id.tv_rating_stars)
    TextView tv_rating_stars;


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

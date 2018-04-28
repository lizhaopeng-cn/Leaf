package com.lzp.movie.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lzp.basemodule.base.BaseActivity;
import com.lzp.movie.R;
import com.lzp.movie.R2;
import com.lzp.movie.been.MovieSubjectsBeen;
import com.lzp.movie.contract.MovieDetailContract;
import com.lzp.movie.presenter.MovieDetailPresenter;

import butterknife.BindView;

/**
 * Created by lzp48947 on 2017/12/25.
 */

public class MovieDetailActivity extends BaseActivity implements MovieDetailContract.IMovieDetailView{

    @BindView(R2.id.image)
    ImageView image;

    @BindView(R2.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R2.id.toolbar)
    Toolbar toolbar;

    @BindView(R2.id.tv_id)
    TextView tvID;

    @BindView(R2.id.tv_title)
    TextView tv_title;

    @BindView(R2.id.tv_original_title)
    TextView tv_original_title;

    @BindView(R2.id.tv_aka)
    TextView tv_aka;

    @BindView(R2.id.tv_alt)
    TextView tv_alt;

    @BindView(R2.id.tv_mobile_url)
    TextView tv_mobile_url;

    @BindView(R2.id.tv_ratings_count)
    TextView tv_ratings_count;

    @BindView(R2.id.tv_wish_count)
    TextView tv_wish_count;

    @BindView(R2.id.tv_collect_count)
    TextView tv_collect_count;

    @BindView(R2.id.tv_do_count)
    TextView tv_do_count;

    @BindView(R2.id.tv_subtype)
    TextView tv_subtype;

    @BindView(R2.id.tv_website)
    TextView tv_website;

    @BindView(R2.id.tv_douban_site)
    TextView tv_douban_site;

    @BindView(R2.id.tv_pubdates)
    TextView tv_pubdates;

    @BindView(R2.id.tv_mainland_pubdate)
    TextView tv_mainland_pubdate;

    @BindView(R2.id.tv_pubdate)
    TextView tv_pubdate;

    @BindView(R2.id.tv_year)
    TextView tv_year;

    @BindView(R2.id.tv_languages)
    TextView tv_languages;

    @BindView(R2.id.tv_durations)
    TextView tv_durations;

    @BindView(R2.id.tv_genres)
    TextView tv_genres;

    @BindView(R2.id.tv_countries)
    TextView tv_countries;

    @BindView(R2.id.tv_summary)
    TextView tv_summary;

    @BindView(R2.id.tv_comments_count)
    TextView tv_comments_count;

    @BindView(R2.id.tv_reviews_count)
    TextView tv_reviews_count;

    @BindView(R2.id.tv_seasons_count)
    TextView tv_seasons_count;

    @BindView(R2.id.tv_current_season)
    TextView tv_current_season;

    @BindView(R2.id.tv_episodes_count)
    TextView tv_episodes_count;

    @BindView(R2.id.tv_schedule_url)
    TextView tv_schedule_url;

    @BindView(R2.id.tv_trailer_urls)
    TextView tv_trailer_urls;

    @BindView(R2.id.tv_clip_urls)
    TextView tv_clip_urls;

    @BindView(R2.id.tv_blooper_urls)
    TextView tv_blooper_urls;

    @BindView(R2.id.tv_photos)
    TextView tv_photos;

    @BindView(R2.id.tv_popular_reviews)
    TextView tv_popular_reviews;

    @BindView(R2.id.tv_rating_min)
    TextView tv_rating_min;

    @BindView(R2.id.tv_rating_max)
    TextView tv_rating_max;

    @BindView(R2.id.tv_rating_average)
    TextView tv_rating_average;

    @BindView(R2.id.tv_rating_stars)
    TextView tv_rating_stars;

    private MovieDetailPresenter movieDetailPresenter;
    @Override
    public int getContentViewId() {
        return R.layout.activity_movie_detail;
    }

    @Override
    public void init() {
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
        movieDetailPresenter = new MovieDetailPresenter();
        movieDetailPresenter.attachView(this);
        movieDetailPresenter.goMovieDetailModelData();
    }

    @Override
    public void setView(MovieSubjectsBeen movieSubjectsBeen) {
        collapsingToolbarLayout.setTitle(movieSubjectsBeen.getTitle());
        Glide.with(MovieDetailActivity.this).load(movieSubjectsBeen.getImages().getSmall()).into(image);
    }

    @Override
    public String getSubjectId() {
        String subjectId = getIntent().getStringExtra("subjectId");
        return subjectId;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(!movieDetailPresenter.isViewAttached()){
            movieDetailPresenter.detachView();
        }
    }
}

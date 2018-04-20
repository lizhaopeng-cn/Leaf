package com.lzp.movie.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzp.basemodule.base.BaseFragment;
import com.lzp.movie.R;
import com.lzp.movie.R2;
import com.lzp.movie.adapter.MyFragmentPagerAdapter;

import com.lzp.basemodule.api.BaseConstants;
import com.lzp.movie.api.MovieConstants;

import java.util.ArrayList;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieFragment extends BaseFragment {

    @BindView(R2.id.fab) FloatingActionButton fab;

    @BindView(R2.id.tabLayout) TabLayout tabLayout;
    @BindView(R2.id.viewPager) ViewPager viewPager;

    @BindString(R2.string.in_theaters) String inTheaters;
    @BindString(R2.string.coming_soon) String comingSoon;
    @BindString(R2.string.top250) String top250;

    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments;
    private MovieFragmentChild inTheatersMovieFragment;
    private MovieFragmentChild comingSoonMovieFragment;
    private MovieFragmentChild top250MovieFragment;

    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private int tabPosition;

    @Override
    public int getContentViewId() {
        return R.layout.app_bar_main;
    }

    @Override
    public void init() {
        initTab();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFabClick();
            }
        });
    }

    private void initTab() {
        //设置title数据
        titles = new ArrayList<>();
        titles.add(inTheaters);
        titles.add(comingSoon);
        titles.add(top250);
        //设置fragment
        fragments = new ArrayList<>();
        inTheatersMovieFragment = MovieFragmentChild.newInstance(MovieConstants.IN_THEATERS);
        comingSoonMovieFragment = MovieFragmentChild.newInstance(MovieConstants.COMING_SOON);
        top250MovieFragment = MovieFragmentChild.newInstance(MovieConstants.TOP_250);
        fragments.add(inTheatersMovieFragment);
        fragments.add(comingSoonMovieFragment);
        fragments.add(top250MovieFragment);
        //绑定fragment
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), fragments, titles);
        viewPager.setAdapter(myFragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        //设置上一次tab
        tabLayout.getTabAt(tabPosition).select();
    }

    @Override
    public void onStop() {
        super.onStop();
        tabPosition = tabLayout.getSelectedTabPosition();
    }

    @OnClick(R2.id.fab)
    void setFabClick(){
        Snackbar.make(fab, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}

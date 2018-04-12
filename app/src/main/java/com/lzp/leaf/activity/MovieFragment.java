package com.lzp.leaf.activity;

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

import com.lzp.leaf.R;
import com.lzp.leaf.adapter.MyFragmentPagerAdapter;
import com.lzp.leaf.api.ApiConstants;
import com.lzp.leaf.base.BaseFragment;
import com.lzp.leaf.fragment.MovieFragmentChild;

import java.util.ArrayList;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieFragment extends BaseFragment{

    @BindView(R.id.fab) FloatingActionButton fab;

    @BindView(R.id.tabLayout) TabLayout tabLayout;
    @BindView(R.id.viewPager) ViewPager viewPager;

    @BindString(R.string.in_theaters) String inTheaters;
    @BindString(R.string.coming_soon) String comingSoon;
    @BindString(R.string.top250) String top250;

    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments;
    private MovieFragmentChild inTheatersMovieFragment;
    private MovieFragmentChild comingSoonMovieFragment;
    private MovieFragmentChild top250MovieFragment;

    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private int tabPosition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.app_bar_main, null);
        ButterKnife.bind(this, view);
        initTab();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFabClick();
            }
        });
        return view;
    }

    private void initTab() {
        //设置title数据
        titles = new ArrayList<>();
        titles.add(inTheaters);
        titles.add(comingSoon);
        titles.add(top250);
        //设置fragment
        fragments = new ArrayList<>();
        inTheatersMovieFragment = MovieFragmentChild.newInstance(ApiConstants.IN_THEATERS);
        comingSoonMovieFragment = MovieFragmentChild.newInstance(ApiConstants.COMING_SOON);
        top250MovieFragment = MovieFragmentChild.newInstance(ApiConstants.TOP_250);
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

    @OnClick(R.id.fab)
    void setFabClick(){
        Snackbar.make(fab, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}

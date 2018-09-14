package com.lzp.movie.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lzp.basemodule.base.BaseFragment;
import com.lzp.movie.R;
import com.lzp.movie.R2;

import com.lzp.movie.activity.MyFragmentPagerAdapter;
import com.lzp.movie.api.MovieConstants;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

public class MovieFragment extends BaseFragment {

    @BindView(R2.id.fab)
    FloatingActionButton fab;

    @BindView(R2.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R2.id.viewPager)
    ViewPager viewPager;

    @BindString(R2.string.in_theaters)
    public String inTheaters;
    @BindString(R2.string.coming_soon)
    public String comingSoon;
    @BindString(R2.string.top250)
    public String top250;

//    private ArrayList<String> titles;
//    private ArrayList<Fragment> fragments;
//    private MovieTypeFragment inTheatersMovieTypeFragment;
//    private MovieTypeFragment comingSoonMovieTypeFragment;
//    private MovieTypeFragment top250MovieTypeFragment;

    @Inject
    MyFragmentPagerAdapter myFragmentPagerAdapter;

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
//        //设置title数据
//        titles = new ArrayList<>();
//        titles.add(inTheaters);
//        titles.add(comingSoon);
//        titles.add(top250);
//        //设置fragment
//        fragments = new ArrayList<>();
//        inTheatersMovieTypeFragment = MovieTypeFragment.newInstance(MovieConstants.IN_THEATERS);
//        comingSoonMovieTypeFragment = MovieTypeFragment.newInstance(MovieConstants.COMING_SOON);
//        top250MovieTypeFragment = MovieTypeFragment.newInstance(MovieConstants.TOP_250);
//        fragments.add(inTheatersMovieTypeFragment);
//        fragments.add(comingSoonMovieTypeFragment);
//        fragments.add(top250MovieTypeFragment);
        //绑定fragment
//        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), fragments, titles);
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

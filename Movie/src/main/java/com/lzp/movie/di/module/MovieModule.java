package com.lzp.movie.di.module;

import android.support.v4.app.Fragment;

import com.lzp.movie.activity.MyFragmentPagerAdapter;
import com.lzp.movie.api.MovieConstants;
import com.lzp.movie.fragment.MovieFragment;
import com.lzp.movie.fragment.MovieTypeFragment;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lzp48947 on 2018/8/30.
 */
@Module
public class MovieModule {
    @Provides
    public MyFragmentPagerAdapter provideMyFragmentPagerAdapter(MovieFragment movieFragment){
        //设置title数据
        ArrayList<String> titles = new ArrayList<>();
        titles.add(movieFragment.inTheaters);
        titles.add(movieFragment.comingSoon);
        titles.add(movieFragment.top250);
        //设置fragment
        ArrayList<Fragment> fragments = new ArrayList<>();
        MovieTypeFragment inTheatersMovieTypeFragment = MovieTypeFragment.newInstance(MovieConstants.IN_THEATERS);
        MovieTypeFragment comingSoonMovieTypeFragment = MovieTypeFragment.newInstance(MovieConstants.COMING_SOON);
        MovieTypeFragment top250MovieTypeFragment = MovieTypeFragment.newInstance(MovieConstants.TOP_250);
        fragments.add(inTheatersMovieTypeFragment);
        fragments.add(comingSoonMovieTypeFragment);
        fragments.add(top250MovieTypeFragment);
        return new MyFragmentPagerAdapter(movieFragment.getChildFragmentManager(), fragments, titles);
    }

    @Provides
    public MovieFragment provideMovieFragment(){
        return new MovieFragment();
    }
}

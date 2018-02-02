package com.lzp.leaf.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.lzp.leaf.R;
import com.lzp.leaf.adapter.MyFragmentPagerAdapter;
import com.lzp.leaf.api.ApiConstants;
import com.lzp.leaf.base.BaseActivity;
import com.lzp.leaf.fragment.MovieFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.nav_view) NavigationView navigationView;

    @BindView(R.id.tabLayout) TabLayout tabLayout;
    @BindView(R.id.viewPager) ViewPager viewPager;

    @BindString(R.string.in_theaters) String inTheaters;
    @BindString(R.string.coming_soon) String comingSoon;
    @BindString(R.string.top250) String top250;

    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments;
    private MovieFragment inTheatersMovieFragment;
    private MovieFragment comingSoonMovieFragment;
    private MovieFragment top250MovieFragment;

    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private int tabPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        initDrawer();

        initTab();
    }

    private void initTab() {
        //设置title数据
        titles = new ArrayList<>();
        titles.add(inTheaters);
        titles.add(comingSoon);
        titles.add(top250);
        //设置fragment
        fragments = new ArrayList<>();
        inTheatersMovieFragment = MovieFragment.newInstance(ApiConstants.IN_THEATERS);
        comingSoonMovieFragment = MovieFragment.newInstance(ApiConstants.COMING_SOON);
        top250MovieFragment = MovieFragment.newInstance(ApiConstants.TOP_250);
        fragments.add(inTheatersMovieFragment);
        fragments.add(comingSoonMovieFragment);
        fragments.add(top250MovieFragment);
        //绑定fragment
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(myFragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        //设置上一次tab
        tabLayout.getTabAt(tabPosition).select();
    }

    @Override
    protected void onStop() {
        super.onStop();
        tabPosition = tabLayout.getSelectedTabPosition();
    }

    private void initDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @OnClick(R.id.fab)
    void setFabClick(){
        Snackbar.make(fab, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            setFabClick();
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(MovieActivity.this, BookActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

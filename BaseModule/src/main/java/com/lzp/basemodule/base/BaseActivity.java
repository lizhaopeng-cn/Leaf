package com.lzp.basemodule.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by lzp on 2017/8/8.
 */

public abstract class BaseActivity extends DaggerAppCompatActivity implements IBaseView{
    private ProgressDialog progressDialog;

    public abstract int getContentViewId();
    public abstract void init();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        init();
    }

    @Override
    public void showLoading() {
        if(!progressDialog.isShowing()){
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if(progressDialog.isShowing()){
            progressDialog.cancel();
        }
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}

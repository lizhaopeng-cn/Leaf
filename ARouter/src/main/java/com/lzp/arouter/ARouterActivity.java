package com.lzp.arouter;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lzp.arouter.databinding.ActivityRouterBinding;
import com.lzp.basemodule.base.BaseActivity;

/**
 * Created by lzp48947 on 2018/4/13.
 */

public class ARouterActivity extends AppCompatActivity {

//    @Override
//    public int getContentViewId() {
//        return R.layout.activity_router;
//    }
//
//    @Override
//    public void init() {
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRouterBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_router);
        Person person = new Person();
        person.setAge(20);
        person.setName("张三");
        binding.setPerson(person);
    }

}

package com.lzp.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by lzp48947 on 2018/4/27.
 */

public class Person extends BaseObservable {
    private String name;
    private int age;
    private String logo;

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public int getAge() {
        return age;
    }

    @Bindable
    public String getLogo() {
        return logo;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(com.lzp.databinding.BR.name);
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(com.lzp.databinding.BR.age);
    }

    public void setLogo(String logo) {
        this.logo = logo;
        notifyPropertyChanged(com.lzp.databinding.BR.logo);
    }
}

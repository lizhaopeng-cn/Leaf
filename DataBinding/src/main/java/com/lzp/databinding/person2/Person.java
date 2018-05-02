package com.lzp.databinding.person2;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * Created by lzp48947 on 2018/4/27.
 */

public class Person{
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();
}

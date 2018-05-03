package com.lzp.databinding.utils;

import android.databinding.BindingConversion;

/**
 * Created by lzp48947 on 2018/5/3.
 */

public class Conversion {
    @BindingConversion
    public static String int2String(int i){
        return String.valueOf(i);
    }
}

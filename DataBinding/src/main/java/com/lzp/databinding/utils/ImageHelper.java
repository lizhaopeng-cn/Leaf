package com.lzp.databinding.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lzp.databinding.R;

/**
 * Created by lzp48947 on 2018/5/3.
 */

public class ImageHelper {
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .error(R.mipmap.ic_launcher_round)
                .into(imageView);
    }
}

package br.com.testedx.java.util;

import com.nostra13.universalimageloader.core.DisplayImageOptions;

import br.com.testedx.R;

/**
 * Created by rafaela.araujo on 03/07/2017.
 */

public class ImageUtil {

    public static DisplayImageOptions getSandwichImageOptions() {
        return new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.sandwich)
                .showImageOnFail(R.drawable.sandwich)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
    }

    public static DisplayImageOptions getIngredientsImageOptions() {
        return new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_ingredient)
                .showImageOnFail(R.drawable.ic_ingredient)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
    }
}

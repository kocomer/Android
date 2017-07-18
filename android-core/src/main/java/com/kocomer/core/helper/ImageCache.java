package com.kocomer.core.helper;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by kocomer on 2017/7/18.
 */

public class ImageCache implements ImageLoader.ImageCache {
    private LruCache<String, Bitmap> mCache;

    public ImageCache() {
        int maxSize = 10 * 1024 * 1024;
        mCache = new LruCache<String, Bitmap>(maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }

        };
    }

    public Bitmap getBitmap(String url) {
        return mCache.get(url);
    }

    public void putBitmap(String url, Bitmap bitmap) {
        mCache.put(url, bitmap);
    }
}

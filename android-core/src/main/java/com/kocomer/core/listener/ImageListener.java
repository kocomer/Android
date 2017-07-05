package com.kocomer.core.listener;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by kocomer on 2017/3/23.
 */

public interface ImageListener {
    void onImageCallback(ImageView imageView, Bitmap bitmap);

    void onImageError(ImageView imageView);

    void onImageBefore(ImageView imageView);

    void onImageAfter(ImageView imageView);
}

package com.martinziserman.movieapp;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.martinziserman.movieapp.Network.LruBitmapCache;

public class MovieApplication extends Application {

    private RequestQueue requestQueue;
    private static MovieApplication instance;
    private ImageLoader imageLoader;

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public static MovieApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MovieApplication.instance = this;

        requestQueue = Volley.newRequestQueue(this);

        LruBitmapCache lruBitmapCache = new LruBitmapCache(8 * 1024 * 1024);

        imageLoader = new ImageLoader(requestQueue, lruBitmapCache);
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }
}

package com.martinziserman.movieapp.Network;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.martinziserman.movieapp.MovieApplication;
import com.martinziserman.movieapp.model.Movie;
import com.martinziserman.movieapp.model.MovieResult;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

import java.util.List;

public class NetworkManager {

    public interface MovieResultListener {
        void onFindMovies(Movie[] movies);
        void onFail();
    }

    public static void findMovies(String title, final MovieResultListener listener) {
        String url = "http://api.themoviedb.org/3/search/movie?api_key=c1ac741d5dd740f9861e794c5363b0c2&query=alien";
        JacksonRequest<MovieResult> request =
                new JacksonRequest<MovieResult>(Request.Method.GET,
                        url,
                        new JacksonRequestListener<MovieResult>() {
            @Override
            public void onResponse(MovieResult response, int statusCode, VolleyError error) {

                if (error!=null) {
                    if (listener!=null) {
                        listener.onFail();
                    }
                } else {
                    if (response!=null) {
                        if (listener!=null) {
                            listener.onFindMovies(response.getResults());
                        }
                    }
                }

            }

            @Override
            public JavaType getReturnType() {
                return SimpleType.construct(MovieResult.class);
            }
        });

        MovieApplication
                .getInstance()
                .getRequestQueue()
                .add(request);

    }
}

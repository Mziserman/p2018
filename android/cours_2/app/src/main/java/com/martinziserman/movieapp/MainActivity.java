package com.martinziserman.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.martinziserman.movieapp.Adapter.MoviesAdapter;
import com.martinziserman.movieapp.Network.NetworkManager;
import com.martinziserman.movieapp.model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Movie> movies = new ArrayList<>();

        ListView moviesListView = (ListView) findViewById(R.id.movies_listview);
        final MoviesAdapter moviesAdapter = new MoviesAdapter(this);

        moviesListView.setAdapter(moviesAdapter);

        moviesAdapter.refreshWithMovies(movies);

        NetworkManager.findMovies("Alien", new NetworkManager.MovieResultListener() {
            @Override
            public void onFindMovies(Movie[] movies) {
                List<Movie> movieList = Arrays.asList(movies);

                moviesAdapter.refreshWithMovies(movieList);
            }

            @Override
            public void onFail() {

            }
        });

    }
}

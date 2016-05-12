package com.martinziserman.movieapp.Adapter;

import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.martinziserman.movieapp.MovieApplication;
import com.martinziserman.movieapp.R;
import com.martinziserman.movieapp.model.Movie;

public class RowMovieHolder {

    private final TextView titleTextView;
    private final NetworkImageView posterImageView;

    public RowMovieHolder(View rowView) {
        titleTextView = (TextView) rowView.findViewById(R.id.row_movie_title_textview);
        posterImageView = (NetworkImageView) rowView.findViewById(R.id.row_movie_poster_imageview);
    }

    public void refreshWithMovie(Movie movie) {
        titleTextView.setText(movie.getTitle());
        String baseUrl = "https://image.tmdb.org/t/p/w130";
        String posterUrl = baseUrl+movie.getPosterPath();
        ImageLoader imageLoader = MovieApplication.getInstance().getImageLoader();

        posterImageView.setImageUrl(posterUrl, imageLoader);
    }

}

package com.martinziserman.movieapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.martinziserman.movieapp.R;
import com.martinziserman.movieapp.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends BaseAdapter {

    private List<Movie> movies;
    private LayoutInflater layoutInflater;

    public MoviesAdapter(Context context) {
        movies = new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View viewFromCache, ViewGroup parent) {

        if (viewFromCache==null) {
            viewFromCache = layoutInflater.inflate(R.layout.row_movie, parent, false);
            viewFromCache.setTag(new RowMovieHolder(viewFromCache));
        }


        Movie movie = movies.get(position);

        //TextView titleTextView = (TextView) viewFromCache.findViewById(R.id.row_movie_title_textview);
        //titleTextView.setText(movie.getTitle());

        RowMovieHolder rowMovieHolder = (RowMovieHolder) viewFromCache.getTag();
        rowMovieHolder.refreshWithMovie(movie);

        return viewFromCache;
    }

    public void refreshWithMovies(List<Movie> movies) {

        this.movies.clear();
        this.movies.addAll(movies);
        notifyDataSetChanged();

    }
}

package com.martinziserman.movieapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieResult {

    private int page;
    private Movie[] results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Movie[] getResults() {
        return results;
    }

    public void setResults(Movie[] results) {
        this.results = results;
    }
}

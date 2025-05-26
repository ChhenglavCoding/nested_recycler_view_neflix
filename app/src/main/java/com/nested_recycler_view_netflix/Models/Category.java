package com.nested_recycler_view_netflix.Models;

import java.util.List;

public class Category {
    private String categoryTitle;
    private List<Movie> movieList;

    public Category(String categoryTitle, List<Movie> movieList) {
        this.categoryTitle = categoryTitle;
        this.movieList = movieList;
    }

    public String getCategoryTitle() { return categoryTitle; }
    public List<Movie> getMovieList() { return movieList; }
}

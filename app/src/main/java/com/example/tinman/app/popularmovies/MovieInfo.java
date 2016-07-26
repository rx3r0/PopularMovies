package com.example.tinman.app.popularmovies;

/**
 * Basic information about a movie.
 *
 * Created by Martin JM Watson on 7/25/16.
 */
public class MovieInfo {
    String movieTitle;      // Movie name
    String releaseDate;     // Date as string
    int poster;             // Drawable reference ID

    public MovieInfo(String title, String date, int image) {
        this.movieTitle = title;
        this.releaseDate = date;
        this.poster = image;
    }
}

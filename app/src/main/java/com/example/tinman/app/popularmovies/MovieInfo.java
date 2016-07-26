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
    double userRating;
    String synopsis;        // Plot synopsis for the movie


    /**
     * Constructor for Movie Info.
     *
     * @param title     Original movie title
     * @param date      Release date
     * @param image     Movie poster
     * @param rating    Average user rating
     * @param plot      Plot synopsis
     */
    public MovieInfo(String title, String date, int image, double rating, String plot) {
        this.movieTitle = title;
        this.releaseDate = date;
        this.poster = image;
        this.userRating = rating;
        this.synopsis = plot;
    }
}

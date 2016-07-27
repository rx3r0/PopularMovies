package com.example.tinman.app.popularmovies;

/**
 * Basic information about a movie.
 *
 * Created by Martin JM Watson on 7/25/16.
 */
public class MovieInfo {
    private String movieTitle;      // Movie name
    private String releaseDate;     // Date as string
    private int poster;             // Drawable reference ID
    private double userRating;
    private String synopsis;        // Plot synopsis for the movie


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

    /**
     * Get movie poster image.
     *
     * @return  Drawable integer ID of movie poster.
     */
    public int getPoster() {
        return poster;
    }

    /**
     * Get the average user rating for a movie.
     *
     * @return  Average user rating usually to 2 decimal places.
     */
    public double getUserRating() {
        return userRating;
    }

    /**
     * Get the original movie title.
     *
     * @return  Original movie title.
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * The release date of the movie.
     *
     * @return  Release date of movie as string formatted as "YYYY-MM-DD".
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * Get the plot synopsis of the movie.
     *
     * @return  Plot synopsis of movie as very long string.
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Set the original movie title.
     *
     * @param movieTitle
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    /**
     * Set the movie poster image.
     *
     * @param poster    Drawable integer ID for image.
     */
    public void setPoster(int poster) {
        this.poster = poster;
    }

    /**
     * Set the release date for the movie.
     *
     * @param releaseDate   Release date as a string formatted as "YYYY-MM-DD".
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Set the plot synopsis for the movie.
     *
     * @param synopsis
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * Set the average user rate for the movie.
     *
     * @param userRating    Average user rating as a double, usually to 2 decimal places.
     */
    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }
}

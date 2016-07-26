package com.example.tinman.app.popularmovies;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Translate supplied movie information object to adapter to be used in views.
 *
 * Created by Martin JM Watson on 7/25/16.
 */
public class MovieInfoAdapter extends ArrayAdapter<MovieInfo> {
    // Log tag for debugging
    private final String LOG_TAG = MovieInfoAdapter.class.getSimpleName();

    /**
     * Custom constructor (doesn't mirror superclass).
     * The context is used to inflate the layout file and the List is the data
     * needed to populate into the lists.
     *
     * @param context       The current context.  Used to inflate layout file.
     * @param movieInfos    A list of MovieInfo object to display in a list
     */
    public MovieInfoAdapter(Activity context, List<MovieInfo> movieInfos) {
        // Initialise the ArrayAdapter's internal storage for the context of the list.
        // The second argument is used when the ArrayAdapter is populating a single TextView.
        // This is a custom adapter for two TextViews and an ImageView, therefore, the Adapter
        // is not going to need the second argument, so it can be any value.  Here it is 0.
        super(context, 0, movieInfos);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc).
     *
     * @param position      AdapterView position that is requesting a view.
     * @param convertView   The recycled view to populate.
     * @param parent        The parent ViewGroup used for inflation.
     * @return              View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Gets the MovieInfo object from the ArrayAdapter at the appropriate position
        MovieInfo movieInfo = getItem(position);

        // Adapters recycle views into AdapterViews.
        // If this is a new view object, inflate the view.
        // If not, this view has already been inflated from previous call to getView.
        // Modify the widgets.
        if (convertView == null) {
            convertView =
                    LayoutInflater.from(getContext())
                            .inflate(R.layout.list_item_movie, parent, false);
        }

        // Get the movie poster
        ImageView posterView = (ImageView) convertView.findViewById(R.id.list_item_poster);
        posterView.setImageResource(movieInfo.poster);

        // Get the movie title
        TextView titleView = (TextView) convertView.findViewById(R.id.list_item_movie_title);
        titleView.setText(movieInfo.movieTitle);;

        // Get the movie release date
        TextView dateView = (TextView) convertView.findViewById(R.id.list_item_release_date);
        dateView.setText(movieInfo.releaseDate);

        return convertView;
    }
}

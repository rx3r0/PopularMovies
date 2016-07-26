package com.example.tinman.app.popularmovies;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    // Log tag for debugging
    private final String LOG_TAG = MovieFragment.class.getSimpleName();

    // Create movie list adapter to be used for translating movie data into view
    private MovieInfoAdapter mMovieAdapter;

    // Create movie info test data
    private MovieInfo[] movieInfo = {
            new MovieInfo("Batman v Superman: Dawn of Justice",
                    "2016-03-23", R.drawable.batmanvsuperman),

            new MovieInfo("The Legend of Tarzan",
                    "2016-06-29", R.drawable.tarzan),

            new MovieInfo("Independence Day: Resurgence",
                    "2016-06-22", R.drawable.independance_day),

            new MovieInfo("The Hunger Games: Mockingjay - Part 1",
                    "2014-11-18", R.drawable.hunger_games),

            new MovieInfo("The Boy Next Door",
                    "2015-01-23", R.drawable.boy_next_door),

            new MovieInfo("Finding Dory",
                    "2016-06-16", R.drawable.finding_dory),

            new MovieInfo("Captain America: Civil War",
                    "2016-04-27", R.drawable.captain_america_civil_war),

            new MovieInfo("Mad Max: Fury Road",
                    "2015-05-13", R.drawable.mad_max),

            new MovieInfo("Ghostbusters",
                    "2016-07-14", R.drawable.ghostbusters)
    };

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_movie, container, false);

        // Initialise the MovieInfoAdapter with the activity context which is the layout's
        // parent activity, and the movieInfo array list with the data.
        mMovieAdapter = new MovieInfoAdapter(getActivity(), Arrays.asList(movieInfo));

        // Populate the list view with the movie data
        ListView listView = (ListView) root.findViewById(R.id.movie_listview);
        listView.setAdapter(mMovieAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MovieInfo movieInfo = (MovieInfo) mMovieAdapter.getItem(i);
                Toast.makeText(getActivity(), movieInfo.movieTitle, Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

}
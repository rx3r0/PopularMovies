package com.example.tinman.app.popularmovies;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    // Log tag for debugging
    private final String LOG_TAG = MovieFragment.class.getSimpleName();

    // Create movie list adapter to be used for translating movie data into view
    private ArrayAdapter mMovieAdapter;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_movie, container, false);

        // Create dummy data for use with testing the view
        String[] dummyData = {
                "Batman v Superman: Dawn of Justice - 2016-03-23",
                "The Legend of Tarzan - 2016-06-29",
                "Independence Day: Resurgence - 2016-06-22",
                "The Hunger Games: Mockingjay - Part 1 - 2014-11-18",
                "The Boy Next Door - 2015-01-23",
                "Finding Dory - 2016-06-16",
                "Captain America: Civil War - 2016-04-27",
                "Mad Max: Fury Road - 2015-05-13",
                "Ghostbusters - 2016-07-14"
        };

        // Put dummy data in list
        List<String> movieList = new ArrayList<>(Arrays.asList(dummyData));

        // Initialise the array adapter with the activity context which is the layout's
        // parent activity, the list item layout, the text view to hold the data, and the
        // array list with the data.
        mMovieAdapter = new ArrayAdapter<>(getActivity(),
                R.layout.list_item_movie,
                R.id.list_item_movie_textview,
                movieList);

        // Populate the list view with the movie data
        ListView listView = (ListView) root.findViewById(R.id.movie_listview);
        listView.setAdapter(mMovieAdapter);

        return root;
    }

}
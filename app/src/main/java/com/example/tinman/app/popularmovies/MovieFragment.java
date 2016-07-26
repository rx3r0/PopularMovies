package com.example.tinman.app.popularmovies;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
                    "2016-03-23", R.drawable.batmanvsuperman, 5.56,
                    "Fearing the actions of a god-like Super Hero left unchecked, Gotham City’s own formidable, forceful vigilante takes on Metropolis’s most revered, modern-day savior, while the world wrestles with what sort of hero it really needs. And with Batman and Superman at war with one another, a new threat quickly arises, putting mankind in greater danger than it’s ever known before."),

            new MovieInfo("The Legend of Tarzan",
                    "2016-06-29", R.drawable.tarzan, 4.61,
                    "Tarzan, having acclimated to life in London, is called back to his former home in the jungle to investigate the activities at a mining encampment."),

            new MovieInfo("Independence Day: Resurgence",
                    "2016-06-22", R.drawable.independance_day, 4.64,
                    "We always knew they were coming back. Using recovered alien technology, the nations of Earth have collaborated on an immense defense program to protect the planet. But nothing can prepare us for the aliens’ advanced and unprecedented force. Only the ingenuity of a few brave men and women can bring our world back from the brink of extinction."),

            new MovieInfo("The Hunger Games: Mockingjay - Part 1",
                    "2014-11-18", R.drawable.hunger_games, 6.72,
                    "Katniss Everdeen reluctantly becomes the symbol of a mass rebellion against the autocratic Capitol."),

            new MovieInfo("The Boy Next Door",
                    "2015-01-23", R.drawable.boy_next_door, 4.5,
                    "A recently cheated on married woman falls for a younger man who has moved in next door, but their torrid affair soon takes a dangerous turn."),

            new MovieInfo("Finding Dory",
                    "2016-06-16", R.drawable.finding_dory, 6.41,
                    "Finding Dory reunites Dory with friends Nemo and Marlin on a search for answers about her past. What can she remember? Who are her parents? And where did she learn to speak Whale?"),

            new MovieInfo("Captain America: Civil War",
                    "2016-04-27", R.drawable.captain_america_civil_war, 6.93,
                    "Following the events of Age of Ultron, the collective governments of the world pass an act designed to regulate all superhuman activity. This polarizes opinion amongst the Avengers, causing two factions to side with Iron Man or Captain America, which causes an epic battle between former allies."),

            new MovieInfo("Mad Max: Fury Road",
                    "2015-05-13", R.drawable.mad_max, 7.31,
                    "An apocalyptic story set in the furthest reaches of our planet, in a stark desert landscape where humanity is broken, and most everyone is crazed fighting for the necessities of life. Within this world exist two rebels on the run who just might be able to restore order. There's Max, a man of action and a man of few words, who seeks peace of mind following the loss of his wife and child in the aftermath of the chaos. And Furiosa, a woman of action and a woman who believes her path to survival may be achieved if she can make it across the desert back to her childhood homeland."),

            new MovieInfo("Ghostbusters",
                    "2016-07-14", R.drawable.ghostbusters, 5.18,
                    "Following a ghost invasion of Manhattan, paranormal enthusiasts Erin Gilbert and Abby Yates, nuclear engineer Jillian Holtzmann, and subway worker Patty Tolan band together to stop the otherworldly threat.")
    };

    public MovieFragment() {
        // Required empty public constructor
    }

    /**
     * Called to do initial creation of a fragment.  This is called after
     * #onAttach(Activity) and before
     * {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * <p>
     * <p>Note that this can be called while the fragment's activity is
     * still in the process of being created.  As such, you can not rely
     * on things like the activity's content view hierarchy being initialized
     * at this point.  If you want to do work once the activity itself is
     * created, see {@link #onActivityCreated(Bundle)}.
     * <p>
     * <p>Any restored child fragments will be created before the base
     * <code>Fragment.onCreate</code> method returns.</p>
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Let fragment handle menu option
        setHasOptionsMenu(true);
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
        GridView gridView = (GridView) root.findViewById(R.id.movie_gridview);
        gridView.setAdapter(mMovieAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MovieInfo movieInfo = mMovieAdapter.getItem(i);
                Toast.makeText(getActivity(), movieInfo.movieTitle, Toast.LENGTH_SHORT).show();



            }
        });

        return root;
    }

    /**
     * Initialize the contents of the Fragment host's standard options menu.  You
     * should place your menu items in to <var>menu</var>.  For this method
     * to be called, you must have first called {@link #setHasOptionsMenu}.  See
     * {@link Activity#onCreateOptionsMenu(Menu) Activity.onCreateOptionsMenu}
     * for more information.
     *
     * @param menu     The options menu in which you place your items.
     * @param inflater
     * @see #setHasOptionsMenu
     * @see #onPrepareOptionsMenu
     * @see #onOptionsItemSelected
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.movie_fragment, menu);
    }

    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     * <p>
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     * @see #onCreateOptionsMenu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle menu item events.  Home/Up actions are handled automatically if parent specified
        // in AndroidManifest.xml
        int id = item.getItemId();

        // If Refresh menu item is selected ...
        if (id == R.id.action_refresh) {
            // Download movie info from The Movie Database
            updateMovieInfo();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Download and update movie information from The Movie Database.
     */
    private void updateMovieInfo() {
        // Check network connectivity
        if (!isOnline()) {
            Toast.makeText(getActivity(), "Network Unavailable", Toast.LENGTH_SHORT).show();
        } else {
            new FetchMovieInfoTask().execute();
        }
    }

    /**
     * Check for network availability.
     *
     * @return  False if unavailable, True if available.
     */
    private boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    private class FetchMovieInfoTask extends AsyncTask<Void, Void, Void> {
        // Log tag for debugging
        private final String LOG_TAG = FetchMovieInfoTask.class.getSimpleName();

        @Override
        protected Void doInBackground(Void... voids) {
            // Create connection and reader objects.
            // Declaration outside the try block allows them to be closed in the finally block.
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            // Raw JSON response as a string
            String movieStr;

            try {
                // Construct URL The Movie Database query
                final String BASE_URL= "api.themoviedb.org";
                final String SHOW_TYPE = "movie";
                final String SORT_TYPE = "popular";
                final String API_KEY_PARAM = "api_key";

                Uri.Builder builder = new Uri.Builder();
                builder.scheme("http")
                        .authority(BASE_URL)
                        .appendPath("3")
                        .appendPath(SHOW_TYPE)
                        .appendPath(SORT_TYPE)
                        .appendQueryParameter(API_KEY_PARAM, BuildConfig.THE_MOVIE_DB_API_KEY)
                        .build();

                Log.v(LOG_TAG, "The Movie Database query URL: " + builder.toString());

                URL tmdbUrl = new URL(builder.toString());

                // Create connect to The Movie Database
                connection = (HttpURLConnection) tmdbUrl.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                // Read the input stream into the string
                InputStream inputStream = connection.getInputStream();
                StringBuffer buffer = new StringBuffer();

                if (inputStream == null) {
                    Log.v(LOG_TAG, "InputStream is null?");
                    return null;
                }

                reader = new BufferedReader(new InputStreamReader(inputStream));

                // Break stream into individual lines.  This is not necessary for parsing, but
                // helps with debugging.
                String line;

                if ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }

                // If the stream was empty, then there is no need to parse.
                if (buffer.length() == 0) {
                    return null;
                }

                movieStr = buffer.toString();

                Log.v(LOG_TAG, "The Movie Database query JSON response: " + movieStr);

            } catch (IOException e) {
                Log.e(LOG_TAG, "Error: ", e);

                return null;
            } finally {
                if (connection != null) {
                    connection.disconnect();

                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(LOG_TAG, "Error closing reader stream", e);
                    }
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

}
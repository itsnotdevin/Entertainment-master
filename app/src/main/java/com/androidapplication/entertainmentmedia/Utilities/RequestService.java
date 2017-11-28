package com.androidapplication.entertainmentmedia.Utilities;
/**
 *
 * Created by devin 11/28
 */
import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.androidapplication.entertainmentmedia.Data.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.androidapplication.entertainmentmedia.Utilities.Constants.TAG_CREW;
import static com.androidapplication.entertainmentmedia.Utilities.Constants.TAG_DATE;
import static com.androidapplication.entertainmentmedia.Utilities.Constants.TAG_DESC;
import static com.androidapplication.entertainmentmedia.Utilities.Constants.TAG_GENRE;
import static com.androidapplication.entertainmentmedia.Utilities.Constants.TAG_IMDB;
import static com.androidapplication.entertainmentmedia.Utilities.Constants.TAG_NETWORK;
import static com.androidapplication.entertainmentmedia.Utilities.Constants.TAG_PIC;
import static com.androidapplication.entertainmentmedia.Utilities.Constants.TAG_TITLE;

public class RequestService extends AppCompatActivity {
    public Movie getMovie() {
        return this.movie;
    }
    Movie movie = new Movie();
    private TextView movieTitle,movieYear,movieDirector,movieActors,movieType,movieRating,movieWriters,moviePlot,
            movieBoxOffice,movieRuntime;
    private ImageView moviePoster;
    private List<Movie> retList;

    public RequestService(){}

    public String getSearchTerm() {
        return searchTerm;
    }
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
    private String searchTerm;

    //get movies
    public Movie GetMovieDetails(final String val){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,Constants.MOVIE_URL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    setSearchTerm(val);

                    JSONArray moviesArray = response.getJSONArray(TAG_TITLE);
                    for(int i = 0; i < moviesArray.length(); i++)
                    {
                        JSONObject moviesObj = moviesArray.getJSONObject(i);
                        if (moviesObj.getString(TAG_TITLE).equalsIgnoreCase(val))
                        {
                            movie.setTitle("Title: " + moviesObj.getString(TAG_TITLE));
                            movie.setAir_date("Air Date: " + moviesObj.getString(TAG_DATE));
                            movie.setGenre("Genre: " + moviesObj.getString(TAG_GENRE));
                            movie.setPic_url(moviesObj.getString(TAG_PIC));
                            movie.setImdb_id(moviesObj.getInt(String.valueOf(TAG_IMDB)));
                            movie.setDescription("Description: " +  moviesObj.getString(TAG_DESC));
                            movie.setNetwork("Production Company: " +  moviesObj.getString(TAG_NETWORK));
                            movie.setCrewMember("Staff: " + moviesObj.getString(TAG_CREW));
                        }
                    }
                } catch (JSONException ex){
                    ex.printStackTrace();
                }
            }},
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ERROR", "error -> " + error.toString());
                    }
                }){ @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            Map<String, String> params = new HashMap<>();
            params.put("X-User-Email", "admin@cop4331-g5.edu");
            params.put("X-User-Token", "cop4331admin");
            return params;
        }
        };
        return movie;
    }

    //get movies
    public List<Movie> GetMovieResults(String val) {
        setSearchTerm(val);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,Constants.MOVIE_URL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONArray moviesArray = response.getJSONArray(TAG_TITLE);
                    for(int i = 0; i < moviesArray.length(); i++)
                    {
                        JSONObject moviesObj = moviesArray.getJSONObject(i);
                        if (moviesObj.getString(TAG_TITLE).equalsIgnoreCase(getSearchTerm())
                                || moviesObj.getString(TAG_CREW).equalsIgnoreCase(getSearchTerm()))
                        {
                            Movie movie = new Movie();
                            movie.setTitle("Title: " + moviesObj.getString(TAG_TITLE));
                            movie.setAir_date("Air Date: " + moviesObj.getString(TAG_DATE));
                            movie.setGenre("Genre: " + moviesObj.getString(TAG_GENRE));
                            movie.setPic_url(moviesObj.getString(TAG_PIC));
                            movie.setImdb_id(moviesObj.getInt(String.valueOf(TAG_IMDB)));
                            retList.add(movie);
                        }
                    }
                } catch (JSONException ex){
                    ex.printStackTrace();
                }
            }},
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR", "error -> " + error.toString());
            }
        }){ @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            Map<String, String> params = new HashMap<>();
            params.put("X-User-Email", "admin@cop4331-g5.edu");
            params.put("X-User-Token", "cop4331admin");
            return params;
        }
        };
        return retList;
    }
}
package com.androidapplication.entertainmentmedia.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.androidapplication.entertainmentmedia.Data.Movie;
import com.androidapplication.entertainmentmedia.Utilities.RequestService;
import com.androidapplication.entertainmentmedia.R;
import com.androidapplication.entertainmentmedia.Utilities.Constants;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;


public class MovieDetailsActivity extends RequestService
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        RequestService rs = new RequestService();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);
        Movie movie = (Movie) getIntent().getSerializableExtra("movie");
        setUpUserInterface();
        rs.GetMovieDetails(movie.getTitle());

    }

    public void setUpUserInterface() {
        TextView movieTitle = (TextView) super.findViewById(R.id.movieTitleDetailsTextView);
        ImageView moviePoster = (ImageView) super.findViewById(R.id.moviePosterDetailsImageVeiw);
        TextView movieYear = (TextView) super.findViewById(R.id.movieYearDetailsTextView);
        TextView movieType = (TextView) super.findViewById(R.id.movieTypeDetailsTextView);
        TextView moviePlot = (TextView) super.findViewById(R.id.moviePlotDetailsTextView);

    }
}


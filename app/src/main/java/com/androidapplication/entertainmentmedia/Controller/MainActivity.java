package com.androidapplication.entertainmentmedia.Controller;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.androidapplication.entertainmentmedia.Data.Movie;
import com.androidapplication.entertainmentmedia.Utilities.RequestService;
import com.androidapplication.entertainmentmedia.Model.MovieRecycleViewAdapter;
import com.androidapplication.entertainmentmedia.R;
import com.androidapplication.entertainmentmedia.Utilities.Preference;

import org.json.JSONException;

import java.util.List;

public class MainActivity extends RequestService {

    private RecyclerView recyclerView;
    private MovieRecycleViewAdapter movieRecycleViewAdapter;
    private List<Movie> movieList;
    private RequestQueue queue;
    private AlertDialog.Builder alertDialogBuilder;
    private AlertDialog dialog;


    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public MovieRecycleViewAdapter getMovieRecycleViewAdapter() {
        return movieRecycleViewAdapter;
    }

    public void setMovieRecycleViewAdapter(MovieRecycleViewAdapter movieRecycleViewAdapter) {
        this.movieRecycleViewAdapter = movieRecycleViewAdapter;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public RequestQueue getQueue() {
        return queue;
    }

    public void setQueue(RequestQueue queue) {
        this.queue = queue;
    }

    public AlertDialog.Builder getAlertDialogBuilder() {
        return alertDialogBuilder;
    }

    public void setAlertDialogBuilder(AlertDialog.Builder alertDialogBuilder) {
        this.alertDialogBuilder = alertDialogBuilder;
    }

    public AlertDialog getDialog() {
        return dialog;
    }

    public void setDialog(AlertDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        queue = Volley.newRequestQueue(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInputDialog();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Preference preference = new Preference(MainActivity.this);
        String search = preference.getSearch();
        movieList = GetMovieResults(search);
        movieRecycleViewAdapter = new MovieRecycleViewAdapter(this, movieList);
        recyclerView.setAdapter(movieRecycleViewAdapter);
        movieRecycleViewAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.new_search){
            showInputDialog();
        }
        return super.onOptionsItemSelected(item);
    }


    public void showInputDialog(){
        alertDialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_view, null);
        final EditText newSearchEdit = (EditText) view.findViewById(R.id.searchEdit);
        Button submitButton = (Button) view.findViewById(R.id.submitButton);

        alertDialogBuilder.setView(view);
        dialog = alertDialogBuilder.create();
        dialog.show();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preference preference = new Preference(MainActivity.this);

                if(!newSearchEdit.getText().toString().isEmpty()){

                    String search = newSearchEdit.getText().toString();
                    preference.setSearch(search);
                    movieList.clear();
                    movieList = GetMovieResults(search);
                    movieRecycleViewAdapter = new MovieRecycleViewAdapter(MainActivity.super.getBaseContext(), movieList);
                    recyclerView.setAdapter(movieRecycleViewAdapter);
                    movieRecycleViewAdapter.notifyDataSetChanged();
                }
                dialog.dismiss();
            }
        });
    }
}

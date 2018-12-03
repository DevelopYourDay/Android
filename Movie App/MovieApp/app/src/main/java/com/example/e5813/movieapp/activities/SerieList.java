package com.example.e5813.movieapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.e5813.movieapp.R;
import com.example.e5813.movieapp.models.Serie;

import java.util.List;

public class SerieList extends AppCompatActivity implements SerieAdapter.SeriesAdapterOnClickHandler{

    private RecyclerView mRecyclerView;
    private ProgressBar mLoadingIndicator;
    private SerieAdapter mSerieAdapter;
    private List<Serie> mlistSerie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list_series);

        mLoadingIndicator = (ProgressBar) findViewById(R.id.widget_progress_bar_list_series);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        mSerieAdapter = new SerieAdapter (this, this, mlistSerie);

        mRecyclerView.setAdapter(mSerieAdapter);

        showLoading();

    }

    private void showLoading() {
        /* Then, hide the weather data */
        mRecyclerView.setVisibility(View.INVISIBLE);
        /* Finally, show the loading indicator */
        mLoadingIndicator.setVisibility(View.VISIBLE);
    }


    private void showSerieDataView() {
        /* First, hide the loading indicator */
        mLoadingIndicator.setVisibility(View.INVISIBLE);
        /* Finally, make sure the weather data is visible */
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(int id) {
        Intent serieDetailIntent = new Intent(SerieList.this,SerieDetails.class);
        startActivity(serieDetailIntent);
    }
}

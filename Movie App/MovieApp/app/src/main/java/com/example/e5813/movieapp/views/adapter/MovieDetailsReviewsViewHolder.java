package com.example.e5813.movieapp.views.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.e5813.movieapp.R;

public class MovieDetailsReviewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    final private MovieDetailsReviewsAdapter.MovieDetailsReviewsAdapterOnClickHandler mClickHandler;
    final TextView mTxtNameAuthor;
    final TextView mTxtNComment;

    public MovieDetailsReviewsViewHolder(@NonNull View itemView, MovieDetailsReviewsAdapter.MovieDetailsReviewsAdapterOnClickHandler handler) {
        super(itemView);
        mClickHandler = handler;
        mTxtNameAuthor = (TextView) itemView.findViewById(R.id.tv_movie_details_review_author);
        mTxtNComment = (TextView) itemView.findViewById(R.id.tv_movie_details_review_content);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int adapterPosition = getAdapterPosition();
        mClickHandler.onClickReviews(adapterPosition);
    }
}

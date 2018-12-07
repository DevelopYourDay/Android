package com.example.e5813.movieapp.views.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e5813.movieapp.R;
import com.example.e5813.movieapp.models.MovieReviews;
import com.example.e5813.movieapp.models.MovieVideos;

import java.util.List;

public class MovieDetailsReviewsAdapter extends RecyclerView.Adapter<MovieDetailsReviewsViewHolder>{

    public interface MovieDetailsReviewsAdapterOnClickHandler {
        void onClickReviews(int id);
    }

    private List<MovieReviews> mMovieDetailsReviewsList;
    private final Context mContext;
    final private MovieDetailsReviewsAdapterOnClickHandler mClickHandler;

    public MovieDetailsReviewsAdapter(Context mContext, MovieDetailsReviewsAdapterOnClickHandler mClickHandler, List<MovieReviews> mMovieDetailsReviewsList) {
        this.mMovieDetailsReviewsList = mMovieDetailsReviewsList;
        this.mContext = mContext;
        this.mClickHandler = mClickHandler;
    }
    /**
     * Usado quando um novo ViewHolder é Criado.
     * @param viewGroup O ViewGroup no qual esses ViewHolders estão contidos.
     * @param viewType usado caso o nosso recyclerView tenha mais que um tipo. Neste caso nao faz diferença so temos um
     *                 tipo de viewType
     * @return
     */
    @NonNull
    @Override
    public MovieDetailsReviewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        int layout = R.layout.movie_details_review_item;
        View view = LayoutInflater.from(mContext).inflate(layout,viewGroup,false);
        view.setFocusable(true);
        return new MovieDetailsReviewsViewHolder(view, mClickHandler);
    }

    /**
     * Chamado pelo RecyclerView para exibir os dados na posicao.
     * é usado o ViewHolder para exibir o Cover do Filme
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MovieDetailsReviewsViewHolder holder, int position) {
        MovieReviews  movieReviews= mMovieDetailsReviewsList.get(position);
        holder.mTxtNameAuthor.setText(movieReviews.getAuthor());
        holder.mTxtNComment.setText(movieReviews.getContent());
    }

    /**
     * Devolve o numero de itens a serem exibidos.
     * Usado em background para ajudar a organizar as visualizações e animações.
     * @return
     */
    @Override
    public int getItemCount() {
        if(null == mMovieDetailsReviewsList) return 0;
        return mMovieDetailsReviewsList.size();
    }


    public void appendMovies(List<MovieReviews> ReviewsToAppend) {
        mMovieDetailsReviewsList.addAll(ReviewsToAppend);
        notifyDataSetChanged();
    }

    public void cleanTrailers() {
        mMovieDetailsReviewsList.clear();
        notifyDataSetChanged();
    }

}

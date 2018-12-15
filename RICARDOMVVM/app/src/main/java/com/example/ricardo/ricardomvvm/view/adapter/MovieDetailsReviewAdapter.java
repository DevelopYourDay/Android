package com.example.ricardo.ricardomvvm.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ricardo.ricardomvvm.R;
import com.example.ricardo.ricardomvvm.Utils.MovieUtils;
import com.example.ricardo.ricardomvvm.databinding.FragmentMovieDetailsReviewBinding;
import com.example.ricardo.ricardomvvm.model.Movie;
import com.example.ricardo.ricardomvvm.model.MovieReview;
import com.example.ricardo.ricardomvvm.view.MovieDetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailsReviewAdapter extends RecyclerView.Adapter<MovieDetailsReviewAdapter.MovieDetailsReviewAdapterViewHolder> {

    public interface MoviesAdapterOnClickHandler {
        void onClick(int id);
    }

    private List<MovieReview> mMovieReviewList;
    private FragmentMovieDetailsReviewBinding movieDetailsReviewBinding;

    public MovieDetailsReviewAdapter() {
        this.mMovieReviewList = new ArrayList<>();
    }

    @NonNull
    @Override public MovieDetailsReviewAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //  movieDetailsReviewBinding =
                 DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_movie_details_review, parent, false);
       // movieDetailsReviewBinding.setMovieDetailsReview(MovieDetailsActivity.movieDetailModel);
        //movieDetailsReviewBinding.setLifecycleOwner(this);
        return new MovieDetailsReviewAdapterViewHolder(movieDetailsReviewBinding);
    }

    /**
     * Chamado pelo RecyclerView para exibir os dados na posicao.
     * é usado o ViewHolder para exibir o Cover do Filme
     * @param holder
     * @param position
     */
    @Override public void onBindViewHolder(MovieDetailsReviewAdapterViewHolder holder, int position) {

    }

    /**
     * Devolve o numero de itens a serem exibidos.
     * Usado em background para ajudar a organizar as visualizações e animações.
     * @return
     */
    @Override
    public int getItemCount() {
        if(null == mMovieReviewList) return 0;
        return mMovieReviewList.size();
    }

    /**
     * Não sera necessariro por agora
     * @param position
     * @return
     */
    public MovieReview getReviewFromList(int position){
        if(position >= 0){
            return mMovieReviewList.get(position);
        }
        return null;
    }

    public void appendReview(List<MovieReview> reviewsToAppend) {
        mMovieReviewList.addAll(reviewsToAppend);
        notifyDataSetChanged();
    }

    /**
     *  ViewHolder MovieAdapter
     *
     */
    public class MovieDetailsReviewAdapterViewHolder extends RecyclerView.ViewHolder {

        FragmentMovieDetailsReviewBinding movieDetailsReviewBinding;

        public MovieDetailsReviewAdapterViewHolder( FragmentMovieDetailsReviewBinding fragmentMovieDetailsReviewBinding) {
            super(fragmentMovieDetailsReviewBinding.getRoot());
            movieDetailsReviewBinding = fragmentMovieDetailsReviewBinding;
        }

        void bindMovie(MovieReview movieReview) {
                    //handler here

        }
    }




}

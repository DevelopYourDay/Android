package com.example.ricardo.ricardomvvm.view.adapter;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ricardo.ricardomvvm.R;
import com.example.ricardo.ricardomvvm.databinding.ItemMovieDetailsReviewBinding;
import com.example.ricardo.ricardomvvm.model.MovieReview;
import com.example.ricardo.ricardomvvm.viewmodel.ItemMovieDetailsReviewViewModel;


import java.util.ArrayList;
import java.util.List;

public class MovieDetailsReviewAdapter extends RecyclerView.Adapter<MovieDetailsReviewAdapter.MovieDetailsReviewAdapterViewHolder> {


    private List<MovieReview> mMovieReviewList;
    private ItemMovieDetailsReviewBinding itemMovieDetailsReviewBinding;

    public MovieDetailsReviewAdapter() {
        this.mMovieReviewList = new ArrayList<>();
    }

    @NonNull
    @Override public MovieDetailsReviewAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       itemMovieDetailsReviewBinding =
                 DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_movie_details_review, parent, false);
        return new MovieDetailsReviewAdapterViewHolder(itemMovieDetailsReviewBinding,parent.getContext());
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

        ItemMovieDetailsReviewBinding itemMovieDetailsReviewBinding;
        Context context;

        public MovieDetailsReviewAdapterViewHolder(ItemMovieDetailsReviewBinding itemMovieDetailsReviewBinding, Context context) {
            super(itemMovieDetailsReviewBinding.getRoot());
            this.itemMovieDetailsReviewBinding = itemMovieDetailsReviewBinding;
            this.context = context;
        }



        void bindMovie(MovieReview movieReview) {
            if (itemMovieDetailsReviewBinding.getViewModel() == null) {
                itemMovieDetailsReviewBinding.setViewModel(new ItemMovieDetailsReviewViewModel());
                itemMovieDetailsReviewBinding.getViewModel().setMovieReviewMutableLiveData(movieReview);
            } else {
                itemMovieDetailsReviewBinding.getViewModel().setMovieReviewMutableLiveData(movieReview);
            }
        }
    }




}

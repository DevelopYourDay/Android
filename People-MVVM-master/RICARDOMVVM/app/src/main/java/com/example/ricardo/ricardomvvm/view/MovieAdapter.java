package com.example.ricardo.ricardomvvm.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ricardo.ricardomvvm.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapterViewHolder> {

    public interface MoviesAdapterOnClickHandler {
        void onClick(int id);
    }

    private List<Movie> mMovieList;
    private final Context mContext;
    final private MoviesAdapterOnClickHandler mClickHandler;

    MovieAdapter() {
        this.mMovieList = Collections.emptyList();
    }

    public MovieAdapter(@NonNull Context context, MoviesAdapterOnClickHandler clickHandler, List<Movie> seriesList) {
        this.mContext = context;
        this.mClickHandler = clickHandler;
        this.mMovieList = seriesList;
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
    public MovieAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        int layout = R.layout.movie_list_item;
        View view = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext(),layout, viewGroup,false);
        view.setFocusable(true);
        return new MovieAdapterViewHolder(view, mClickHandler);
    }

    /**
     * Chamado pelo RecyclerView para exibir os dados na posicao.
     * é usado o ViewHolder para exibir o Cover do Filme
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MovieAdapterViewHolder holder, int position) {
        Movie movie = mMovieList.get(position);
    }

    /**
     * Devolve o numero de itens a serem exibidos.
     * Usado em background para ajudar a organizar as visualizações e animações.
     * @return
     */
    @Override
    public int getItemCount() {
        if(null == mMovieList) return 0;
        return mMovieList.size();
    }

    /**
     * Devolve um filme
     * @param position
     * @return
     */
    public Movie getMovieFromList(int position){
        if(position >= 0){
            return mMovieList.get(position);
        }
        return null;
    }


    public void appendMovies(List<Movie> moviesToAppend) {
        mMovieList.addAll(moviesToAppend);
        notifyDataSetChanged();
    }

    public void cleanMovies() {
        mMovieList.clear();
        notifyDataSetChanged();
    }





}

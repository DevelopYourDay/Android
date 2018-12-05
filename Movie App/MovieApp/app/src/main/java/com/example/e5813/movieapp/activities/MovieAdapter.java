package com.example.e5813.movieapp.activities;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.e5813.movieapp.R;
import com.example.e5813.movieapp.models.Movie;
import com.example.e5813.movieapp.utils.MovieUtils;
import com.squareup.picasso.Picasso;


import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapterViewHolder> {

    public interface MoviesAdapterOnClickHandler {
        void onClick(int id);
    }

    private List<Movie> mMovieList;
    private final Context mContext;
    final private MoviesAdapterOnClickHandler mClickHandler;

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
        View view = LayoutInflater.from(mContext).inflate(layout,viewGroup,false);
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
        Picasso.get().load(MovieUtils.getFullUrlImage(movie.getUrlImage())).into(holder.movieCoverImage);
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





}

package com.example.e5813.movieapp.views.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e5813.movieapp.R;
import com.example.e5813.movieapp.models.Movie;
import com.example.e5813.movieapp.models.MovieVideos;
import com.example.e5813.movieapp.utils.MovieUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieDetailsTrailerAdapter  extends RecyclerView.Adapter<MovieDetailsTrailersViewHolder>{

    public interface MovieDetailsTrailerAdapterOnClickHandler {
        void onClickTrailer(int id);
    }

    private List<MovieVideos> mMovieDetailsVideosList;
    private final Context mContext;
    final private MovieDetailsTrailerAdapterOnClickHandler mClickHandler;

    public MovieDetailsTrailerAdapter(Context mContext, MovieDetailsTrailerAdapterOnClickHandler mClickHandler,List<MovieVideos> mMovieDetailsVideosList) {
        this.mMovieDetailsVideosList = mMovieDetailsVideosList;
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
    public MovieDetailsTrailersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        int layout = R.layout.fragment_list_trailer;
        View view = LayoutInflater.from(mContext).inflate(layout,viewGroup,false);
        view.setFocusable(true);
        return new MovieDetailsTrailersViewHolder(view, mClickHandler);
    }

    /**
     * Chamado pelo RecyclerView para exibir os dados na posicao.
     * é usado o ViewHolder para exibir o Cover do Filme
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MovieDetailsTrailersViewHolder holder, int position) {
        MovieVideos  movieVideos = mMovieDetailsVideosList.get(position);
        holder.mTxtNameTrailer.setText(movieVideos.getName());
    }

    /**
     * Devolve o numero de itens a serem exibidos.
     * Usado em background para ajudar a organizar as visualizações e animações.
     * @return
     */
    @Override
    public int getItemCount() {
        if(null == mMovieDetailsVideosList) return 0;
        return mMovieDetailsVideosList.size();
    }


    public void appendMovies(List<MovieVideos> trailersToAppend) {
        mMovieDetailsVideosList.addAll(trailersToAppend);
        notifyDataSetChanged();
    }

    public void cleanTrailers() {
        mMovieDetailsVideosList.clear();
        notifyDataSetChanged();
    }

}

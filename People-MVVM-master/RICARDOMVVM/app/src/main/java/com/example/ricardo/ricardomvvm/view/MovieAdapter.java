package com.example.ricardo.ricardomvvm.view;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ricardo.ricardomvvm.Utils.MovieUtils;
import com.example.ricardo.ricardomvvm.R;
import com.example.ricardo.ricardomvvm.model.Movie;
import com.example.ricardo.ricardomvvm.databinding.ActivityMovieBinding;
import com.example.ricardo.ricardomvvm.databinding.ItemMovieBinding;
import com.example.ricardo.ricardomvvm.viewmodel.ItemMovieViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {

    public interface MoviesAdapterOnClickHandler {
        void onClick(int id);
    }

    private List<Movie> mMovieList;

    public MovieAdapter() {
        this.mMovieList = new ArrayList<>();
    }


    @NonNull
    @Override public MovieAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieBinding itemMovieBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_movie,
                        parent, false);
        return new MovieAdapterViewHolder(itemMovieBinding);
    }

    /**
     * Chamado pelo RecyclerView para exibir os dados na posicao.
     * é usado o ViewHolder para exibir o Cover do Filme
     * @param holder
     * @param position
     */
    @Override public void onBindViewHolder(MovieAdapterViewHolder holder, int position) {
        holder.bindMovie(mMovieList.get(position));
        Picasso.get().load(MovieUtils.getFullUrlImage(mMovieList.get(position).getUrlImage())).into(holder.mItemMovieBinding.imgCoverMovie);
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

    public void update(List<Movie> movies){
        if(mMovieList.size() >0 ){
            mMovieList.clear();
        }
        mMovieList.addAll(movies);
        notifyDataSetChanged();
    }


    public void cleanMovies() {
        mMovieList.clear();
        notifyDataSetChanged();
    }


    /**
     *  ViewHolder MovieAdapter
     *
     */

    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder {

        ItemMovieBinding mItemMovieBinding;


        public MovieAdapterViewHolder( ItemMovieBinding itemMovieBinding) {
            super(itemMovieBinding.getRoot());
            mItemMovieBinding = itemMovieBinding;
        }


        void bindMovie(Movie movie) {
            if (mItemMovieBinding.getMovieItemViewModel() == null) {
                mItemMovieBinding.setMovieItemViewModel(
                        new ItemMovieViewModel(movie, itemView.getContext()));
            } else {
                mItemMovieBinding.getMovieItemViewModel().setMovie(movie);
            }
        }
    }




}

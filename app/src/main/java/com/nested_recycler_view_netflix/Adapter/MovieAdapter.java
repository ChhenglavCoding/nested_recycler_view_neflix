package com.nested_recycler_view_netflix.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import com.bumptech.glide.Glide;
import com.nested_recycler_view_netflix.Models.Movie;
import com.nested_recycler_view_netflix.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> movies;
    private Context context;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.tvTitle.setText(movie.getTitle());
        // Use Glide or Picasso to load images
        Glide.with(holder.itemView.getContext())
                .load(movie.getImageUrl())
                .into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvTitle;

        MovieViewHolder(View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivMovieImage);
            tvTitle = itemView.findViewById(R.id.tvMovieTitle);
        }
    }
}

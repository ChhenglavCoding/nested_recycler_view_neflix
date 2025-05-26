package com.nested_recycler_view_netflix.Adapter;

import android.content.Context;
import android.graphics.Movie;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.transition.Hold;
import com.nested_recycler_view_netflix.Models.Category;
import com.nested_recycler_view_netflix.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<Category> categories;
    private Context context;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.tvCategoryTitle.setText(category.getCategoryTitle());

        MovieAdapter movieAdapter = new MovieAdapter(context, category.getMovieList());
        holder.rvMovies.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.rvMovies.setAdapter(movieAdapter);

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategoryTitle;
        RecyclerView rvMovies;

        CategoryViewHolder(View itemView) {
            super(itemView);
            tvCategoryTitle = itemView.findViewById(R.id.tvCategoryTitle);
            rvMovies = itemView.findViewById(R.id.movieRecyclerView);
        }
    }
}


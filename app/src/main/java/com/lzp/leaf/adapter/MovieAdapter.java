package com.lzp.leaf.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lzp.leaf.R;
import com.lzp.leaf.been.MovieBeen;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lzp on 2017/8/10.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    private Context context;
    private MovieBeen movieBeen;
    private List<MovieBeen.SubjectsBean> movies;

    public MovieAdapter(Context context, MovieBeen movieBeen){
        this.context = context;
        this.movieBeen = movieBeen;
        this.movies = movieBeen.getSubjects();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie_gride, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        MovieBeen.SubjectsBean movie = movies.get(position);
        Glide.with(context).load(movie.getImages().getMedium()).into(holder.image);
        holder.title.setText(movie.getTitle());
        holder.rating.setText(String.valueOf(movie.getRating().getAverage()));
//        holder.director.setText(movie.getDirectors().get(0).getName());
//        holder.casts.setText(movie.getCasts().get(0).getName());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_movie)
        ImageView image;
        @BindView(R.id.tv_movie_title)
        TextView title;
        @BindView(R.id.tv_movie_rating)
        TextView rating;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

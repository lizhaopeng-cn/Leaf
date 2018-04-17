package com.lzp.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lzp.movie.R;
import com.lzp.movie.R2;
import com.lzp.movie.activity.MovieDetailActivity;
import com.lzp.movie.been.MovieBeen;
import com.lzp.movie.been.MovieSubjectsBeen;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lzp on 2017/8/10.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    private Context context;
    private MovieBeen movieBeen;
    private List<MovieSubjectsBeen> movies;

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
        final MovieSubjectsBeen movie = movies.get(position);
        Glide.with(context).load(movie.getImages().getMedium()).into(holder.image);
        holder.title.setText(movie.getTitle());
        holder.rating.setText(String.valueOf(movie.getRating().getAverage()));
//        holder.director.setText(movie.getDirectors().get(0).getName());
//        holder.casts.setText(movie.getCasts().get(0).getName());
        Log.i("onClick","onBindViewHolder"+position);

        holder.rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("onClick","rating");
                Snackbar.make(v,"rating",Snackbar.LENGTH_SHORT).show();
            }
        });
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieDetailActivity.class);
                intent.putExtra("subjectId", movie.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{

        @BindView(R2.id.iv_movie)
        ImageView image;
        @BindView(R2.id.tv_movie_title)
        TextView title;
        @BindView(R2.id.tv_movie_rating)
        TextView rating;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("onClick","title");
                    Snackbar.make(v,"title",Snackbar.LENGTH_SHORT).show();
                }
            });
        }
    }
}

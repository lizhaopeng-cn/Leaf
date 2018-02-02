package com.lzp.leaf.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lzp.leaf.R;
import com.lzp.leaf.been.book.BookBeen;
import com.lzp.leaf.been.book.BookSubjectsBeen;
import com.lzp.leaf.been.movie.MovieBeen;
import com.lzp.leaf.been.movie.MovieSubjectsBeen;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lzp48947 on 2018/1/30.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{

    private Context context;
    private BookBeen bookBeen;
    private List<BookSubjectsBeen> books;

    public BookAdapter(Context context, BookBeen bookBeen){
        this.context = context;
        this.bookBeen = bookBeen;
        this.books = bookBeen.getBooks();
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false);
        return new BookAdapter.BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        final BookSubjectsBeen book = books.get(position);
        Glide.with(context).load(book.getImages().getMedium()).into(holder.image);
        holder.title.setText(book.getTitle());
        holder.price.setText(book.getPrice());
        String author = "";
        for(int i = 0; i < book.getAuthor().size(); i++){
            if(i == 0){
                author = book.getAuthor().get(0);
            }else {
                author = String.format("&，&", author);
            }
        }
        holder.author.setText(author);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_book)
        ImageView image;
        @BindView(R.id.tv_title)
        TextView title;
        @BindView(R.id.tv_author)
        TextView author;
        @BindView(R.id.tv_price)
        TextView price;

        public BookViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

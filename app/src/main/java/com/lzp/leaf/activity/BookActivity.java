package com.lzp.leaf.activity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lzp.leaf.R;
import com.lzp.leaf.adapter.BookAdapter;
import com.lzp.leaf.api.Api;
import com.lzp.leaf.api.ApiService;
import com.lzp.leaf.api.RxSubscriber;
import com.lzp.leaf.base.BaseActivity;
import com.lzp.leaf.been.book.BookBeen;
import com.lzp.leaf.been.movie.MovieBeen;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

/**
 * Created by lzp48947 on 2018/1/26.
 */

public class BookActivity extends BaseActivity {

    @BindView(R.id.et_keyword)
    EditText etKeyword;

    @BindView(R.id.btn_search)
    Button btnSearch;

    @BindView(R.id.rv_result)
    RecyclerView rvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        ButterKnife.bind(this);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSearch();
            }
        });
    }

    public void toSearch(){
        ApiService apiService = Api.getApiService();
        Observable<BookBeen> observableBooks = apiService.getBooks(etKeyword.getText().toString());
        Api.setSubscribe(observableBooks, new RxSubscriber<BookBeen>() {
            @Override
            public void onNext(BookBeen bookBeen) {
                if(bookBeen != null){
                    BookAdapter bookAdapter = new BookAdapter(BookActivity.this, bookBeen);
                    rvResult.setLayoutManager(new LinearLayoutManager(BookActivity.this));
                    rvResult.setAdapter(bookAdapter);
                }
            }
        });
    }
}

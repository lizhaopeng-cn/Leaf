package com.lzp.leaf.activity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lzp.leaf.R;
import com.lzp.leaf.adapter.BookAdapter;
import com.lzp.leaf.api.Api;
import com.lzp.leaf.api.ApiService;
import com.lzp.leaf.api.RxSubscriber;
import com.lzp.leaf.base.BaseActivity;
import com.lzp.leaf.base.BaseFragment;
import com.lzp.leaf.been.book.BookBeen;
import com.lzp.leaf.been.movie.MovieBeen;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

/**
 * Created by lzp48947 on 2018/1/26.
 */

public class BookFragment extends BaseFragment {

    @BindView(R.id.et_keyword)
    EditText etKeyword;

    @BindView(R.id.btn_search)
    Button btnSearch;

    @BindView(R.id.rv_result)
    RecyclerView rvResult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_book, null);
        ButterKnife.bind(this, view);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSearch();
            }
        });
        return view;
    }

    public void toSearch(){
        ApiService apiService = Api.getApiService();
        Observable<BookBeen> observableBooks = apiService.getBooks(etKeyword.getText().toString());
        Api.setSubscribe(observableBooks, new RxSubscriber<BookBeen>() {
            @Override
            public void onNext(BookBeen bookBeen) {
                if(bookBeen != null){
                    BookAdapter bookAdapter = new BookAdapter(getActivity(), bookBeen);
                    rvResult.setLayoutManager(new LinearLayoutManager(getActivity()));
                    rvResult.setAdapter(bookAdapter);
                }
            }
        });
    }
}

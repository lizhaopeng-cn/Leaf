package com.example.book.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.book.R;
import com.example.book.R2;
import com.example.book.adapter.BookAdapter;
import com.example.book.api.ApiService;
import com.example.book.been.BookBeen;
import com.lzp.basemodule.BaseFragment;
import api.Api;

import api.RxSubscriber;
import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

/**
 * Created by lzp48947 on 2018/1/26.
 */

public class BookFragment extends BaseFragment {

    @BindView(R2.id.et_keyword)
    EditText etKeyword;

    @BindView(R2.id.btn_search)
    Button btnSearch;

    @BindView(R2.id.rv_result)
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
        ApiService apiService = Api.getApiService().create(ApiService.class);
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

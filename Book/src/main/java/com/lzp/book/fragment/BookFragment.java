package com.lzp.book.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lzp.book.R;
import com.lzp.book.R2;
import com.lzp.book.adapter.BookAdapter;
import com.lzp.book.been.BookBeen;
import com.lzp.basemodule.base.BaseFragment;

import com.lzp.book.contract.IBookContract;
import com.lzp.book.presenter.BookPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lzp48947 on 2018/1/26.
 */

public class BookFragment extends BaseFragment implements IBookContract.IBookView {

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
        final BookPresenter bookPresenter = new BookPresenter(this);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookPresenter.goBookModelData(etKeyword.getText().toString());
            }
        });
        return view;
    }

    @Override
    public void toSearch(BookBeen bookBeen) {
        BookAdapter bookAdapter = new BookAdapter(getActivity(), bookBeen);
        rvResult.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvResult.setAdapter(bookAdapter);
    }
}

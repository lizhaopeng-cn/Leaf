package com.lzp.book.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
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
import com.lzp.book.databinding.ActivityBookBinding;
import com.lzp.book.presenter.BookPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lzp48947 on 2018/1/26.
 */

public class BookFragment extends BaseFragment implements IBookContract.IBookView {
    private BookPresenter bookPresenter;

//    @BindView(R2.id.et_keyword)
//    EditText etKeyword;
//
//    @BindView(R2.id.btn_search)
//    Button btnSearch;
//
//    @BindView(R2.id.rv_result)
//    RecyclerView rvResult;

    private ActivityBookBinding binding;

    @Override
    public int getContentViewId() {
        return R.layout.activity_book;
    }

    @Override
    public void init() {
        bookPresenter = new BookPresenter();
        bookPresenter.attachView(this);
//        btnSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bookPresenter.goBookModelData();
//            }
//        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_book, container, false);
        BookBeen bookBeen = new BookBeen();
        bookBeen.setStart(0);
        bookBeen.setCount(10);
        bookBeen.setTotal(100);
        binding.setBookBeen(bookBeen);
//        binding.setOnClickListener(this);
        init();

        binding.setSearchClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookPresenter.goBookModelData();
            }
        });
        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookPresenter.goBookModelData();
            }
        });
        return binding.getRoot();
    }

    public void searchClick(){
        bookPresenter.goBookModelData();
    }

    @Override
    public void toSearch(BookBeen bookBeen) {
        BookAdapter bookAdapter = new BookAdapter(getActivity(), bookBeen);
        binding.rvResult.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvResult.setAdapter(bookAdapter);
    }

    @Override
    public String getKeyword() {
        return binding.etKeyword.getText().toString();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(bookPresenter.isViewAttached()){
            bookPresenter.detachView();
        }
    }

}

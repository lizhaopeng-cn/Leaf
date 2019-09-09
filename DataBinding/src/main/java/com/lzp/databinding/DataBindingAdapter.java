package com.lzp.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzp.databinding.databinding.ItemRecyclerBinding;

import java.util.List;

/**
 * Created by lzp48947 on 2018/5/3.
 */

public class DataBindingAdapter extends RecyclerView.Adapter<DataBindingAdapter.MyViewHodler>{
    private Context context;
    private List<com.lzp.databinding.person2.Person> personList;

    public DataBindingAdapter(Context context, List<com.lzp.databinding.person2.Person> personList){
        this.context = context;
        this.personList = personList;
    }
    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRecyclerBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_recycler, parent, false);
        return new MyViewHodler(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(MyViewHodler holder, int position) {
        ItemRecyclerBinding binding = DataBindingUtil.getBinding(holder.itemView);
        binding.setPerson(personList.get(position));
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class  MyViewHodler extends RecyclerView.ViewHolder{

        public MyViewHodler(View itemView) {
            super(itemView);
        }
    }
}

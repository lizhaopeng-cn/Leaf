package com.lzp.databinding;


import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.lzp.databinding.databinding.ActivityDatabindingBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lzp48947 on 2018/4/13.
 */

public class DataBindingActivity extends AppCompatActivity {
    private ActivityDatabindingBinding binding;
    private Person person;
    private com.lzp.databinding.person2.Person person2;
    private ObservableArrayMap<String,Object> person3;
    private DataBindingAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        setData();
        setCollection();
        setPerson1();
        setPerson2();
        setPerson3();
        setClick1();
        setClick2();
        binding.setButton3(this);
        setRecyclerView();
    }

    private void setData() {
        binding.setStr("小明");
        binding.setI(10);
    }

    private void setCollection() {
        List<String> list = new ArrayList<>();
        list.add("list1");
        list.add("list2");
        binding.setList(list);

        HashMap<String, String> map = new HashMap<>();
        map.put("key0", "map_value0");
        map.put("key1", "map_value1");
        binding.setMap(map);

        String[] arrays = {"字符串1", "字符串2"};
        binding.setArray(arrays);
    }

    private void setPerson1() {
        person = new Person();
        person.setAge(20);
        person.setName("张三");
        person.setLogo("https://www.baidu.com/img/bd_logo1.png");
        binding.setPerson(person);
    }

    private void setPerson2() {
        person2 = new com.lzp.databinding.person2.Person();
        person2.age.set(30);
        person2.name.set("李四");
        binding.setPerson2(person2);
    }

    private void setPerson3() {
        person3 = new ObservableArrayMap<>();
        person3.put("age", 40);
        person3.put("name", "王五");
        binding.setPerson3(person3);
    }

    private void setClick1() {
        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person.setName("张三click");
            }
        });
    }

    private void setClick2() {
        binding.setButton2(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person2.name.set("李四click");
            }
        });
    }

    private void setRecyclerView() {
        List<com.lzp.databinding.person2.Person> personList = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            personList.add(person2);
        }

        adapter = new DataBindingAdapter(this, personList);
        binding.recycle.setLayoutManager(new LinearLayoutManager(this));
        binding.recycle.setAdapter(adapter);
    }

    public void click(View view){
        person3.put("name", "王五click");
//        adapter.notifyDataSetChanged();
    }

}

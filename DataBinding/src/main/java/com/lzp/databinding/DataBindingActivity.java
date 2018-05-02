package com.lzp.databinding;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lzp.databinding.databinding.ActivityDatabindingBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lzp48947 on 2018/4/13.
 */

public class DataBindingActivity extends AppCompatActivity {

//    @Override
//    public int getContentViewId() {
//        return R.layout.activity_router;
//    }
//
//    @Override
//    public void init() {
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDatabindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        binding.setStr("张三");
        binding.setI(10);

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

        final Person person = new Person();
        person.setAge(20);
        person.setName("李四");
        binding.setPerson(person);

        com.lzp.databinding.person2.Person person2 = new com.lzp.databinding.person2.Person();
        person2.setName("赵六");
        binding.setPerson2(person2);

        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person.setName("王五");
                Toast.makeText(DataBindingActivity.this, "王五", Toast.LENGTH_SHORT).show();
            }
        });
        binding.setButton2(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DataBindingActivity.this, "王五", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

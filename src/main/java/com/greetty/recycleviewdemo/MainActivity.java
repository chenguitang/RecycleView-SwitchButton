package com.greetty.recycleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.greetty.recycleviewdemo.bean.Student;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private List<Student> listStudents;

    @BindView(R.id.rv_select)
    RecyclerView rvSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    private void initView() {
        rvSelect.setLayoutManager(new LinearLayoutManager(this));
        rvSelect.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void initData() {
        listStudents = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            if (i % 2 == 0)
                listStudents.add(new Student("Data" + i, false));
            else
                listStudents.add(new Student("Test" + i, false));
        }
        MyRecycleViewAdapter myAdapter = new MyRecycleViewAdapter(listStudents, this);

        rvSelect.setAdapter(myAdapter);

    }
}

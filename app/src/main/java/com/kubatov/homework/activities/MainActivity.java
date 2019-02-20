package com.kubatov.homework.activities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.kubatov.homework.R;
import com.kubatov.homework.adapters.TaskAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView taskslist;
    TaskAdapter taskAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutManager = new LinearLayoutManager(this);

        taskAdapter = new TaskAdapter();

        taskslist = findViewById(R.id.tasks_recycler);

        taskslist.setAdapter(taskAdapter);
        taskslist.setLayoutManager(layoutManager);

    }

    void init (){

    }

}
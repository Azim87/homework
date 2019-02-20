package com.kubatov.homework.activities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;


import com.kubatov.homework.R;
import com.kubatov.homework.adapters.TaskAdapter;
import com.kubatov.homework.models.Task;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView tasksList;
    TaskAdapter taskAdapter;
    RecyclerView.LayoutManager layoutManager;





    List<Task> tasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTasks();
        initRecycler(tasks);

    }

    void initRecycler (List<Task> taskList) {
        layoutManager = new LinearLayoutManager(this);
        taskAdapter = new TaskAdapter(taskList);
        tasksList = findViewById(R.id.tasks_recycler);
        tasksList.setAdapter(taskAdapter);
        tasksList.setLayoutManager(layoutManager);
    }

    void setTasks(){
        tasks = new ArrayList<>();
        tasks.add(new Task("Task 1", R.drawable.pics,"Description 1"));
        tasks.add(new Task("Task 2", R.drawable.pics,"Description 2"));
        tasks.add(new Task("Task 3", R.drawable.pics,"Description 3"));
        tasks.add(new Task("Task 4", R.drawable.pics,"Description 4"));
        tasks.add(new Task("Task 5", R.drawable.pics,"Description 5"));
    }

}
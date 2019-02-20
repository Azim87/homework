package com.kubatov.homework.activities;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.kubatov.homework.R;
import com.kubatov.homework.adapters.TaskAdapter;
import com.kubatov.homework.models.Task;

import java.io.File;
import java.net.URL;
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
        tasks.add(new Task("Task 1", "Description 1", R.drawable.pics));
        tasks.add(new Task("Task 2", "Description 2", R.drawable.pics));
        tasks.add(new Task("Task 3", "Description 3", R.drawable.pics));
        tasks.add(new Task("Task 4", "Description 4", R.drawable.pics));
        tasks.add(new Task("Task 5", "Description 5", R.drawable.pics));
    }

}
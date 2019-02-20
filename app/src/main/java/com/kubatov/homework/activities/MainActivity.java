package com.kubatov.homework.activities;


import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;


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
    Boolean isScrolling = false;
    int currentItems, totalItems, scrollOutItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        setTasks();
        initRecycler(tasks);

    }

    void initRecycler (final List<Task> taskList) {
        layoutManager = new LinearLayoutManager(this);
        taskAdapter = new TaskAdapter(taskList);
        tasksList = findViewById(R.id.tasks_recycler);
        tasksList.setAdapter(taskAdapter);
        tasksList.setLayoutManager(layoutManager);

            taskAdapter.notifyDataSetChanged();


        tasksList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling = true;
                }

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItems = layoutManager.getChildCount();
                totalItems = layoutManager.getItemCount();

                try {
                    scrollOutItems = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                }catch (NullPointerException e){}

                if (isScrolling && (currentItems + scrollOutItems == totalItems)){
                    isScrolling = false;
                    fetchData();
                }



            }
        });
    }

    private void fetchData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <5; i++){
                    tasks.add(new Task("Task 1", R.drawable.pics,"Description 1"));
                    taskAdapter.notifyDataSetChanged();
                }
            }
        }, 500);
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
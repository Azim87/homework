package com.kubatov.homework.activities;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


import com.kubatov.homework.Fragments.textviewFr.TextViewFragment;
import com.kubatov.homework.R;
import com.kubatov.homework.adapters.TaskAdapter;
import com.kubatov.homework.interfaces.IOnClickListener;
import com.kubatov.homework.models.Task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnClickListener {

    RecyclerView tasksList;
    TaskAdapter taskAdapter;
    RecyclerView.LayoutManager layoutManager;
        Button button;


    List<Task> tasks;
    //Boolean isScrolling = false;
   // int currentItems, totalItems, scrollOutItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTasks();
        initRecycler(tasks);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TextViewFragment fragment = new TextViewFragment();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

    }

    void initRecycler(List<Task> taskList) {
        layoutManager = new LinearLayoutManager(this);
        taskAdapter = new TaskAdapter(taskList, this);
        tasksList = findViewById(R.id.tasks_recycler);
        tasksList.setAdapter(taskAdapter);
        tasksList.setLayoutManager(layoutManager);

//        tasksList.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
//                    isScrolling = true;
//                }
//            }
//
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                currentItems = layoutManager.getChildCount();
//                totalItems = layoutManager.getItemCount();
//
//                try {
//                    scrollOutItems = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
//                } catch (NullPointerException e) {
//                }
//
//                if (isScrolling && (currentItems + scrollOutItems == totalItems)) {
//                    isScrolling = false;
//                    fetchData();
//                }
//            }
//        });
//
//    }
//
//    private void fetchData() {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    tasks.add(task1);
//                    tasks.add(task2);
//                    tasks.add(task3);
//                    tasks.add(task4);
//                    tasks.add(task5);
//                    taskAdapter.notifyDataSetChanged();
//                }
//            }
//        }, 1500);
   }

//        Task task1 = new Task(1,"Task1", "Description 1", "q");
//        Task task2 = new Task(2,"Task2", "Description 2", "q");
//        Task task3 = new Task(3,"Task3", "Description 3", "q");
//        Task task4 = new Task(4,"Task4", "Description 4", "q");
//        Task task5 = new Task(5,"Task5", "Description 5", "q");
//
   void setTasks() {
       tasks = new ArrayList<>();
//        tasks.add(task1);
//        tasks.add(task2);
//        tasks.add(task3);
//        tasks.add(task4);
//        tasks.add(task5);
       }


    public void onAddNewTask(View v){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    public void clickOn(int taskId) {

        Intent intent = new Intent(this, TaskDetails.class);
        intent.putExtra(Main2Activity.TASK_KEY, (Serializable) tasks.get(taskId));
        startActivity(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK) {
                Task task = (Task) data.getSerializableExtra("task");
                tasks.add(task);
                taskAdapter.notifyDataSetChanged();
            }
        }
    }

}
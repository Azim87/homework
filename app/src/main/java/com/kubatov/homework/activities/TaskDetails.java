package com.kubatov.homework.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.kubatov.homework.R;
import com.kubatov.homework.models.Task;

public class TaskDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        TextView task_title;
        TextView task_description;
        TextView task_image;

        Intent intent = getIntent();
        Task task = (Task) intent.getSerializableExtra("task");

        task_title = findViewById(R.id.task_title);
        task_description = findViewById(R.id.task_description);
        task_image = findViewById(R.id.task_image);

        task_title.setText(task.title);
        task_description.setText(task.description);
        task_image.setText(task.image);


    }
}

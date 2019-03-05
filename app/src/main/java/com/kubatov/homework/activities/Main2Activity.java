package com.kubatov.homework.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.kubatov.homework.R;
import com.kubatov.homework.models.Task;

public class Main2Activity extends AppCompatActivity {
    public static final String TASK_KEY = "task";

    EditText edTaskTitle;
    EditText edTaskDescr;
    EditText edTaskImage;
    String sTaskTitle;
    String sTaskDescr;
    String sTaskImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edTaskTitle = findViewById(R.id.task_title_edit_text);
        edTaskDescr = findViewById(R.id.task_description_edit_text);
        edTaskImage = findViewById(R.id.task_image_edit_text);

        edTaskTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                sTaskTitle = s.toString();

            }
        });
        edTaskImage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                sTaskImage = s.toString();

            }
        });
        edTaskDescr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                sTaskDescr = s.toString();

            }
        });
    }

    public void onCreateTask(View v){

                Task task = new Task(0, sTaskTitle, sTaskImage, sTaskDescr);
                Intent intent = new Intent();
                intent.putExtra(TASK_KEY, task);
                Main2Activity.this.setResult(RESULT_OK, intent);
                Main2Activity.this.finish();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

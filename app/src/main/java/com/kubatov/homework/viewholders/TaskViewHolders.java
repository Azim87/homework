package com.kubatov.homework.viewholders;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kubatov.homework.R;
import com.kubatov.homework.models.Task;


public class TaskViewHolders extends RecyclerView.ViewHolder {

    private TextView textView;
    private TextView textView2;
    private ImageView imageView;

    public TaskViewHolders(@NonNull View itemView){
        super(itemView);

        textView = itemView.findViewById(R.id.vh_task_title);
        textView2 = itemView.findViewById(R.id.vh_task_description);
        imageView = itemView.findViewById(R.id.vh_task_image);
    }

    public void onBind(Task task){
        textView.setText(task.title);
        textView2.setText(task.description);
        imageView.setImageResource(task.image);
    }
}



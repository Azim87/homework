package com.kubatov.homework.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kubatov.homework.R;

public class TaskViewHolders extends RecyclerView.ViewHolder {

    private TextView textView;

    public TaskViewHolders(@NonNull View itemView){
        super(itemView);
        textView = itemView.findViewById(R.id.vh_task_title);
    }

    public void onBind(String title){
        textView.setText(title);
    }
}



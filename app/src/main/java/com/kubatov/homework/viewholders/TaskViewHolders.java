package com.kubatov.homework.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.kubatov.homework.R;
import com.kubatov.homework.interfaces.IOnClickListener;
import com.kubatov.homework.models.Task;



public class TaskViewHolders extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView description;
    private IOnClickListener mListener;
    private int taskId;

    public TaskViewHolders(@NonNull View itemView, IOnClickListener listener){
        super(itemView);
        mListener = listener;
        title = itemView.findViewById(R.id.vh_task_title);
        description = itemView.findViewById(R.id.vh_task_description);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.clickOn(taskId);
            }
        });

    }

    public void onBind(Task task){
        taskId = task.id;
        title.setText(task.title);
        description.setText(task.description);

    }
}



package com.kubatov.homework.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kubatov.homework.R;
import com.kubatov.homework.viewholders.TaskViewHolders;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolders> {

    @NonNull
    @Override
    public TaskViewHolders onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_holder_task, viewGroup, false);
        Log.d("222", "create = " + i);

        TaskViewHolders vh = new TaskViewHolders(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolders taskViewHolders, int i) {
    taskViewHolders.onBind("OLOLOLOLO");
        Log.d("222", "bind = " + i);

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
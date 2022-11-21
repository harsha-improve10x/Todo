package com.example.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListViewHolder> {

    public ArrayList<TaskList> tasksLists;

    public void setTasksLists(ArrayList<TaskList> tasksLists1) {
        tasksLists = tasksLists1;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TaskListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_task_list_xml_file, parent, false);
        TaskListViewHolder taskListViewHolder = new TaskListViewHolder(view);
        return taskListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskListViewHolder holder, int position) {
        TaskList taskList = tasksLists.get(position);
        holder.nameTxt.setText(taskList.name);
        holder.messageTxt.setText(taskList.description);
    }

    @Override
    public int getItemCount() {
        return tasksLists.size();
    }
}

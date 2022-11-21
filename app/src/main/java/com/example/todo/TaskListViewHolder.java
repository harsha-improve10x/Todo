package com.example.todo;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskListViewHolder extends RecyclerView.ViewHolder {

    TextView nameTxt;
    TextView messageTxt;
    CheckBox checkBox;

    public TaskListViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTxt = itemView.findViewById(R.id.name_txt);
        messageTxt = itemView.findViewById(R.id.message_txt);
        checkBox = itemView.findViewById(R.id.check_box_cb);
    }
}

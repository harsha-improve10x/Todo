package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity {
    public ArrayList<TaskList> taskLists;
    public RecyclerView taskListRv;
    public TaskListAdapter taskListAdapter;
    Button addTaskBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        getSupportActionBar().setTitle("Task List");
        addTaskBtn = findViewById(R.id.add_task_list_btn);
        setAddTaskBtn();
        setTaskListsData();
        setTaskListRv();
    }

    public void setAddTaskBtn() {
        addTaskBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddTaskActivity.class);
            startActivity(intent);
        });
    }

    public void setTaskListRv() {
        taskListRv = findViewById(R.id.task_list_rv);
        taskListRv.setLayoutManager(new LinearLayoutManager(this));
        taskListAdapter = new TaskListAdapter();
        taskListAdapter.setTasksLists(taskLists);
        taskListRv.setAdapter(taskListAdapter);
    }

    public void setTaskListsData() {
        taskLists = new ArrayList<>();

        TaskList getVegetables = new TaskList();
        getVegetables.name = "Get vegetables";
        getVegetables.description = "for 1 week";
        taskLists.add(getVegetables);

        TaskList readingNews = new TaskList();
        readingNews.name = "Reading news";
        readingNews.description = "Explore politics, filmy and sport news";
        taskLists.add(readingNews);

        TaskList prepareLunch = new TaskList();
        prepareLunch.name = "Prepare Lunch";
        prepareLunch.description = "Biryani and Raitha. yummyyyyy";
        taskLists.add(prepareLunch);

        TaskList haveBreakfast = new TaskList();
        haveBreakfast.name = "Have Breakfast";
        haveBreakfast.description = "Healthy breakfast for a better morning";
        taskLists.add(haveBreakfast);
    }
}
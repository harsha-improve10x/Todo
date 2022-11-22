package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskListActivity extends AppCompatActivity {
    public ArrayList<TaskList> taskLists = new ArrayList<>();
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
        setTaskListRv();
        fetchData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();
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
        taskListAdapter.setData(taskLists);
        taskListRv.setAdapter(taskListAdapter);
    }

    public void fetchData() {
        TodoApi todoApi = new TodoApi();
        TodoService todoService = todoApi.createTodoService();
        Call<List<TaskList>>call = todoService.fetchTasks();
        call.enqueue(new Callback<List<TaskList>>() {
            @Override
            public void onResponse(Call<List<TaskList>> call, Response<List<TaskList>> response) {
                List<TaskList> taskLists = response.body();
                taskListAdapter.setData(taskLists);
            }

            @Override
            public void onFailure(Call<List<TaskList>> call, Throwable t) {
                Toast.makeText(TaskListActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
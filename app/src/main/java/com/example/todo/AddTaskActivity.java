package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTaskActivity extends AppCompatActivity {
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        getSupportActionBar().setTitle("Add Task");
        addBtn = findViewById(R.id.add_task_name_btn);
        handleAddBtn();
    }
    public void handleAddBtn() {
        addBtn.setOnClickListener(view -> {
            EditText taskNameTxt = findViewById(R.id.names_txt);
            String taskName = taskNameTxt.getText().toString();
            EditText taskDescriptionTxt = findViewById(R.id.description_txt);
            String taskDescription = taskDescriptionTxt.getText().toString();
            addTask(taskName,taskDescription);
        });
    }

    private void addTask(String taskName, String taskDescription) {
        TaskList taskList = new TaskList();
        taskList.name = taskName;
        taskList.description = taskDescription;
        
        TodoApi todoApi = new TodoApi();
        TodoService service = todoApi.createTodoService();
        Call<TaskList> call = service.createTask(taskList);
        call.enqueue(new Callback<TaskList>() {
            @Override
            public void onResponse(Call<TaskList> call, Response<TaskList> response) {
                Toast.makeText(AddTaskActivity.this, "Successfully added new task", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<TaskList> call, Throwable t) {
                Toast.makeText(AddTaskActivity.this, "failed to add new task", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addTask() {
    }
}
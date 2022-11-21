package com.example.todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TodoService {
    @GET("todo")
    Call<List<TaskList>> fetchTasks();
}

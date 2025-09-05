package com.ishan.todolist.Controller;

import com.ishan.todolist.Service.TaskService;
import com.ishan.todolist.model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("create")
    public Task createtask(@RequestBody Task task){
        return taskService.createTask(task);
    }
    @GetMapping("get")
    public List<Task> getAllTasks(){ return taskService.getAllTasks(); }
    @PatchMapping("patch")
    public Task updateTask(@RequestBody Task task){ return taskService.updateTask(task); }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") int id){
        return taskService.deleteTask(id);
    }
}

package com.ishan.todolist.Service;

import com.ishan.todolist.Repository.TaskRepository;
import com.ishan.todolist.exception.TaskNotFoundException;
import com.ishan.todolist.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public ResponseEntity<String> createTask(Task task) {
        taskRepository.save(task);
        return new ResponseEntity<>("task created successfully", HttpStatus.CREATED);
    }
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(taskRepository.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<String> deleteTask(int id) {
        taskRepository.findById(id).orElseThrow(()-> new TaskNotFoundException("task does not exist"));
        taskRepository.deleteById(id);
        return new ResponseEntity<>("task deleted successfully", HttpStatus.OK);
    }
    public ResponseEntity<Task> updateTask(Task updatedTask) {
        Task task = taskRepository.findById(updatedTask.getId()).orElseThrow(()-> new TaskNotFoundException("task does not exist"));

        if (updatedTask.getCategory() != null){ task.setCategory(updatedTask.getCategory()); }
        if (updatedTask.getStatus() != null){ task.setStatus(updatedTask.getStatus()); }
        if (updatedTask.getPriority() != null){ task.setPriority(updatedTask.getPriority()); }
        if (updatedTask.getDueDate() != null){ task.setDueDate(updatedTask.getDueDate()); }
        if (updatedTask.getTitle() != null){ task.setTitle(updatedTask.getTitle()); }
        if (updatedTask.getDescription() != null){ task.setDescription(updatedTask.getDescription()); }

        return new ResponseEntity<>(taskRepository.save(task), HttpStatus.OK);
    }
}

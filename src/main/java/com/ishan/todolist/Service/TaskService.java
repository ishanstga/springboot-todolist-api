package com.ishan.todolist.Service;

import com.ishan.todolist.Repository.TaskRepository;
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

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
    public List<Task> getAllTasks() { return taskRepository.findAll(); }
    public ResponseEntity<String> deleteTask(int id) {
        taskRepository.deleteById(id);
        return new ResponseEntity<>("Task deleted successfully.", HttpStatus.OK);
    }
    public Task updateTask(Task updatedTask) {
        Task task = taskRepository.findById(updatedTask.getId()).orElseThrow(()-> new RuntimeException("Task does not exist."));

        if (updatedTask.getCategory() != null){ task.setCategory(updatedTask.getCategory()); }
        if (updatedTask.getStatus() != null){ task.setStatus(updatedTask.getStatus()); }
        if (updatedTask.getPriority() != null){ task.setPriority(updatedTask.getPriority()); }
        if (updatedTask.getDueDate() != null){ task.setDueDate(updatedTask.getDueDate()); }
        if (updatedTask.getTitle() != null){ task.setTitle(updatedTask.getTitle()); }
        if (updatedTask.getDescription() != null){ task.setDescription(updatedTask.getDescription()); }

        return taskRepository.save(task);
    }
}

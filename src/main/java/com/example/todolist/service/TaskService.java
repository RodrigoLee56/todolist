package com.example.todolist.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.entity.Task;
import com.example.todolist.entity.User;
import com.example.todolist.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasks(User user) {
        return taskRepository.findByUser(user);
    }

    public void save(Task task) {
        if (task.getId() == null) {
            task.setCreatedAt(LocalDateTime.now());
        } else {
            task.setUpdatedAt(LocalDateTime.now());
        }
        taskRepository.save(task);
    }

    public Task getById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
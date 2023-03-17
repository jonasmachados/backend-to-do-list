package com.jonas.backendtodolist.services;

import com.jonas.backendtodolist.projection.TaskByToDoListProjection;
import com.jonas.backendtodolist.repositories.TaskRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
  
    @Autowired
    private TaskRepository repository;
    
    public List<TaskByToDoListProjection> findTaskByToDoList(long id) {
        return repository.findTaskByToDoList(id);
    }
    
}

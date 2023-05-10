package com.jonas.backendtodolist.services;

import com.jonas.backendtodolist.entity.Task;
import com.jonas.backendtodolist.projection.TaskByToDoListProjection;
import com.jonas.backendtodolist.repositories.TaskRepository;
import com.jonas.backendtodolist.services.exceptions.ResourceNotFoundException;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<TaskByToDoListProjection> findTaskByToDoList(long id) {
        return repository.findTaskByToDoList(id);
    }

    public Task update(Long id, Task task) {
        try {
            Task entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(id));
            updateData(entity, task);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Task entity, Task task) {
        entity.setTitle(task.getTitle());
        entity.setContent(task.getContent());
        entity.setTaskStatus(task.getTaskStatus());
        entity.setDateInitial(task.getDateInitial());
    }

}

package com.jonas.backendtodolist.services;

import com.jonas.backendtodolist.entity.ToDoList;
import com.jonas.backendtodolist.repositories.ToDoListRepository;
import com.jonas.backendtodolist.services.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {

    @Autowired
    private ToDoListRepository repository;

    public List<ToDoList> findAll() {
        return repository.findAll();
    }
    
    public ToDoList findById(Long id) {
        Optional<ToDoList> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

}

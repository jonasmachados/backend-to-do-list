package com.jonas.backendtodolist.services;

import com.jonas.backendtodolist.entity.ToDoList;
import com.jonas.backendtodolist.repositories.ToDoListRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {

    @Autowired
    private ToDoListRepository repository;

    public List<ToDoList> findAll() {
        return repository.findAll();
    }

}

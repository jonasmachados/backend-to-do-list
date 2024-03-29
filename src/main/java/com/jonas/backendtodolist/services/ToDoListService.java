package com.jonas.backendtodolist.services;

import com.jonas.backendtodolist.entity.Task;
import com.jonas.backendtodolist.entity.ToDoList;
import com.jonas.backendtodolist.repositories.TaskRepository;
import com.jonas.backendtodolist.repositories.ToDoListRepository;
import com.jonas.backendtodolist.services.exceptions.DatabaseException;
import com.jonas.backendtodolist.services.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {

    @Autowired
    private ToDoListRepository repository;

    @Autowired
    private TaskRepository taskRepository;

    public List<ToDoList> findAll() {
        return repository.findAll();
    }

    public ToDoList findById(Long id) {
        Optional<ToDoList> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public ToDoList insert(ToDoList obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public ToDoList updateName(Long id, ToDoList toDoList) {
        ToDoList entity = getToDoListById(id);
        entity.setName(toDoList.getName());
        return repository.save(entity);
    }

    private ToDoList getToDoListById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    private ToDoList verifyIfExists(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public ToDoList save(ToDoList toDoList) {
        return repository.save(toDoList);
    }

    public ToDoList addTask(Long id, Task task) {
        ToDoList toDoList = verifyIfExists(id);
        task = taskRepository.save(task);
        toDoList.addTask(task);
        ToDoList savedToDoList = repository.save(toDoList);
        return savedToDoList;
    }

}

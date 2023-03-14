package com.jonas.backendtodolist.resources;

import com.jonas.backendtodolist.entity.ToDoList;
import com.jonas.backendtodolist.services.ToDoListService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/toDoLists")
public class ToDoListResource {

    @Autowired
    private ToDoListService service;

    @GetMapping
    public ResponseEntity<List<ToDoList>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToDoList> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

}

package com.jonas.backendtodolist.resources;

import com.jonas.backendtodolist.projection.TaskByToDoListProjection;
import com.jonas.backendtodolist.services.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public class TaskResource {
    
    @Autowired
    private TaskService service;
    
    @GetMapping("/findTaskByToDoList/{id}")
    public ResponseEntity<List<TaskByToDoListProjection>> findTaskByToDoList(@PathVariable("id") long id){
        List<TaskByToDoListProjection> list = service.findTaskByToDoList(id);
        return ResponseEntity.ok().body(list);
    }
}

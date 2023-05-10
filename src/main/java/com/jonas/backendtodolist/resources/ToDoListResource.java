package com.jonas.backendtodolist.resources;

import com.jonas.backendtodolist.entity.Task;
import com.jonas.backendtodolist.entity.ToDoList;
import com.jonas.backendtodolist.services.ToDoListService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "*")
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

    @PostMapping
    public ResponseEntity<ToDoList> insert(@RequestBody ToDoList obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<ToDoList> updateName(@PathVariable Long id, @RequestBody ToDoList toDoList) {
        ToDoList updatedToDoList = service.updateName(id, toDoList);
        return ResponseEntity.ok().body(updatedToDoList);
    }

    @PostMapping("/{todoListId}/tasks")
    public ResponseEntity<Task> addTaskToList(@PathVariable Long todoListId, @RequestBody Task task) {
        ToDoList toDoList = service.findById(todoListId);
        service.addTask(todoListId, task);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(toDoList.getId()).toUri();
        return ResponseEntity.created(uri).body(task);
    }

}

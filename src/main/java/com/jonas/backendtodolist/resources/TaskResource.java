package com.jonas.backendtodolist.resources;

import com.jonas.backendtodolist.dtos.TaskDTO;
import com.jonas.backendtodolist.services.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/task")
public class TaskResource {

    @Autowired
    private TaskService service;

    @GetMapping("/findTaskByToDoList/{id}")
    public List<TaskDTO> findTaskByToDoList(@PathVariable long id) {
        return service.findTaskByToDoList(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable long id, @RequestBody TaskDTO taskDTO) {
        TaskDTO updatedTask = service.update(id, taskDTO);
        return ResponseEntity.ok(updatedTask);
    }

}

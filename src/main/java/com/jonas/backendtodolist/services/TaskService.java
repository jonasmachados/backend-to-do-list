package com.jonas.backendtodolist.services;

import com.jonas.backendtodolist.dtos.TaskDTO;
import com.jonas.backendtodolist.entity.Task;
import com.jonas.backendtodolist.entity.enums.TaskStatus;
import com.jonas.backendtodolist.projection.TaskByToDoListProjection;
import com.jonas.backendtodolist.repositories.TaskRepository;
import com.jonas.backendtodolist.services.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private ModelMapper mapper;

    @PostConstruct
    public void setupMapper() {
        mapper.addConverter(context -> {
            Integer code = context.getSource();
            return code != null ? TaskStatus.valueOf(code) : null;
        }, Integer.class, TaskStatus.class);
    }

    public List<TaskDTO> findTaskByToDoList(long id) {
        List<TaskByToDoListProjection> projections = repository.findTaskByToDoList(id);
        return projections.stream()
                .map(projection -> mapper.map(projection, TaskDTO.class))
                .collect(Collectors.toList());
    }

    public TaskDTO update(long id, TaskDTO taskDTO) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        mapper.map(taskDTO, task);

        Task updatedTask = repository.save(task);
        return TaskDTO.fromEntity(updatedTask);
    }

}

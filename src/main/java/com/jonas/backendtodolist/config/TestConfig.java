package com.jonas.backendtodolist.config;

import com.jonas.backendtodolist.entity.Task;
import com.jonas.backendtodolist.entity.ToDoList;
import com.jonas.backendtodolist.entity.enums.TaskStatus;
import com.jonas.backendtodolist.repositories.TaskRepository;
import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.jonas.backendtodolist.repositories.ToDoListRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ToDoListRepository toDoListkRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {

        ToDoList toDoList = new ToDoList(null, "Main Project", "2019-06-20T21:53:07Z");
        ToDoList toDoListSecond = new ToDoList(null, "Second Project", "2020-06-20T21:53:07Z");
        ToDoList toDoListThird = new ToDoList(null, "Third Project", "2021-06-20T21:53:07Z");
        toDoListkRepository.saveAll(Arrays.asList(toDoList, toDoListSecond, toDoListThird));

        Task task1 = new Task(null, "Buy dog food.", "Content ...", TaskStatus.NOT_STARTED, "2019-06-20T21:53:07Z");
        Task task2 = new Task(null, "Read book It Starts with Us.", "page 223", TaskStatus.IN_PROGRESS, "2019-06-20T21:53:07Z");
        Task task3 = new Task(null, "Title 3", "Content ...", TaskStatus.IN_PROGRESS, "2019-06-20T21:53:07Z");
        Task task4 = new Task(null, "Title 4", "Content ...", TaskStatus.COMPLETED, "2019-06-20T21:53:07Z");
        taskRepository.saveAll(Arrays.asList(task1, task2, task3, task4));

        toDoList.getListTasks().add(task1);
        toDoList.getListTasks().add(task2);
        toDoList.getListTasks().add(task3);
        toDoList.getListTasks().add(task4);
        toDoListkRepository.saveAll(Arrays.asList(toDoList));
    }

}

package com.jonas.backendtodolist.repositories;

import com.jonas.backendtodolist.entity.Task;
import com.jonas.backendtodolist.projection.TaskByToDoListProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT ID, TITLE, CONTENT, TASK_STATUS, DATE_INITIAL FROM TB_TASK"
            + " INNER JOIN TB_TO_DO_LIST_LIST_TASKS"
            + " ON TB_TO_DO_LIST_LIST_TASKS.LIST_TASKS_ID = TB_TASK.ID"
            + " WHERE TO_DO_LIST_ID = :id", nativeQuery = true)
    List<TaskByToDoListProjection> findTaskByToDoList(long id);

}

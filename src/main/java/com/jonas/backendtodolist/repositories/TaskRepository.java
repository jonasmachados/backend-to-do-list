package com.jonas.backendtodolist.repositories;

import com.jonas.backendtodolist.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}

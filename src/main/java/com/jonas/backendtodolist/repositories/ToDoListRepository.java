package com.jonas.backendtodolist.repositories;

import com.jonas.backendtodolist.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

}

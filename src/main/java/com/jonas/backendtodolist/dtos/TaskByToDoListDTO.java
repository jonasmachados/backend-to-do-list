package com.jonas.backendtodolist.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jonas.backendtodolist.entity.enums.TaskStatus;
import com.jonas.backendtodolist.projection.TaskByToDoListProjection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskByToDoListDTO {

    private String title;
    private String content;
    private Integer taskStatus;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", shape = JsonFormat.Shape.STRING, timezone = "GMT")
    private String dateInitial;

    public TaskByToDoListDTO() {
    }

    public TaskByToDoListDTO(String title, String content, TaskStatus taskStatus, String dateInitial) {
        this.title = title;
        this.content = content;
        setTaskStatus(taskStatus);
        this.dateInitial = dateInitial;
    }

    public TaskByToDoListDTO(TaskByToDoListProjection projection) {
        title = projection.getTitle();
        content = projection.getContent();
        taskStatus = projection.getTask_Status();
        dateInitial = projection.getDate_Initial();
    }

    public TaskStatus getTaskStatus() {
        return TaskStatus.valueOf(taskStatus);
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        if (taskStatus != null) {
            this.taskStatus = taskStatus.getCode();
        }
    }

}

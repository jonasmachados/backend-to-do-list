package com.jonas.backendtodolist.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jonas.backendtodolist.entity.enums.TaskStatus;
import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_task")
public class Task {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Title is required!")
    @Length(min = 3, max = 20, message = "Title must have between 3 to 20 characters")
    private String title;

    @NotEmpty(message = "Content is required!")
    @Length(min = 3, max = 500, message = "Content must have between 3 to 500 characters")
    private String content;

    private Integer taskStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'", timezone = "GMT")
    private Instant dateInitial;

    public Task(Long id, String title, String content, TaskStatus taskStatus, Instant dateInitial) {
        this.id = id;
        this.title = title;
        this.content = content;
        setTaskStatus(taskStatus);
        this.dateInitial = dateInitial;
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

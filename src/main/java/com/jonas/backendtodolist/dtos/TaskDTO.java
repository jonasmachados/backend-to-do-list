package com.jonas.backendtodolist.dtos;

import com.jonas.backendtodolist.entity.Task;
import com.jonas.backendtodolist.entity.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Long id;

    private String title;

    private String content;

    private Integer taskStatus;

    private String dateInitial;

    public TaskStatus getTaskStatus() {
        if (taskStatus != null) {
            return TaskStatus.valueOf(taskStatus);
        } else {
            return null;
        }
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        if (taskStatus != null) {
            this.taskStatus = taskStatus.getCode();
        } else {
            this.taskStatus = null;
        }
    }

    public static TaskDTO fromEntity(Task entity) {
        ModelMapper modelMapper = new ModelMapper();

        Converter<Integer, TaskStatus> taskStatusConverter = ctx -> ctx
                .getSource() != null ? TaskStatus.valueOf(ctx.getSource()) : null;

        modelMapper.addConverter(taskStatusConverter);

        return modelMapper.map(entity, TaskDTO.class);
    }

}

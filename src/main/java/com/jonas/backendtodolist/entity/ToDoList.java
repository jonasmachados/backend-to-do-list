package com.jonas.backendtodolist.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_to_do_list")
public class ToDoList {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is required!")
    @Length(min = 3, max = 20, message = "Name must have between 3 to 20 characters")
    private String name;

    @NotNull(message = "Campo date é requerido")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", shape = JsonFormat.Shape.STRING, timezone = "GMT")
    private String dateInitial;

    @OneToMany
    @OrderBy("taskStatus")
    private List<Task> listTasks = new ArrayList<>();

    public ToDoList(Long id, String name, String dateInitial) {
        this.id = id;
        this.name = name;
        this.dateInitial = dateInitial;
    }
    
    public void addTask() {
    }

    public void removeTask() {
    }

}

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'", timezone = "GMT")
    private Instant dateInitial;

    @OneToMany
    private List<Task> listTasks = new ArrayList<>();

    public void addTask() {
    }

    public void removeTask() {
    }

}

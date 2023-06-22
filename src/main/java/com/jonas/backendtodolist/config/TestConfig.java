package com.jonas.backendtodolist.config;

import com.jonas.backendtodolist.entity.Task;
import com.jonas.backendtodolist.entity.ToDoList;
import com.jonas.backendtodolist.entity.enums.TaskStatus;
import com.jonas.backendtodolist.repositories.TaskRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.jonas.backendtodolist.repositories.ToDoListRepository;

@Configuration
@Profile("prod")
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

        Task task1 = new Task(null, "Ir ao supermercado.", "Comprar frutas, legumes, produto de limpeza e raçãoo para o cachorro", TaskStatus.NOT_STARTED, "2019-06-20T21:53:07Z");
        Task task2 = new Task(null, "Organizar a mesa de trabalho", "Organize papéis e arquivos importantes e passar alcool na mesa", TaskStatus.IN_PROGRESS, "2019-06-20T21:53:07Z");
        Task task3 = new Task(null, "Estudar para o exame de história", "Revise as notas de aula e fazer exercicios", TaskStatus.IN_PROGRESS, "2019-06-20T21:53:07Z");
        Task task4 = new Task(null, "Escrever um artigo de opinião sobre política", "Realizar pesquisa eleitoral", TaskStatus.COMPLETED, "2019-06-20T21:53:07Z");
        Task task5 = new Task(null, "Estudar ingles", "Assista aulas onlin e praticar conversação.", TaskStatus.IN_PROGRESS, "2019-06-20T21:53:07Z");
        Task task6 = new Task(null, "Limpar a casa", "Aspirar e passar pano no chão, limpar janelas, trocar as roupas de cama e limpar banheiros.", TaskStatus.NOT_STARTED, "2019-06-20T21:53:07Z");
        Task task7 = new Task(null, "Atualizar o currículo", "Alterar habilidades e experiências mais recentes", TaskStatus.IN_PROGRESS, "2019-06-20T21:53:07Z");
        Task task8 = new Task(null, "Organizar o armário", "Separe as roupas que não usa maise fazer uma limpeza geral", TaskStatus.COMPLETED, "2019-06-20T21:53:07Z");
        taskRepository.saveAll(Arrays.asList(task1, task2, task3, task4, task5, task6, task7, task8));

        toDoList.getListTasks().add(task1);
        toDoList.getListTasks().add(task2);
        toDoList.getListTasks().add(task3);
        toDoList.getListTasks().add(task4);
        toDoList.getListTasks().add(task5);
        toDoList.getListTasks().add(task6);
        toDoList.getListTasks().add(task7);
        toDoList.getListTasks().add(task8);
        toDoListkRepository.saveAll(Arrays.asList(toDoList));
    }

}

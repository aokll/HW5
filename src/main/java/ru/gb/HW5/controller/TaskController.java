package ru.gb.HW5.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.HW5.model.Task;
import ru.gb.HW5.model.TaskStatus;
import ru.gb.HW5.repository.TaskRepository;
import ru.gb.HW5.service.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private final TaskService service;

    @GetMapping("/all")
    public List<Task> getAllTasks(){
       return service.getAllTasks();
    }


    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return service.getTaskByStatus(status);
    }
    @PostMapping
    public String addTask(@RequestBody Task task){
        service.createTask(task);
        return "added completed";
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id){
        service.deleteTaskById(id);
        return "deleted completed";
    }
    @GetMapping("/byid/{id}")
    public Task getTaskById(@PathVariable Long id){
        return service.getTaskById(id);
    }
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id,
                                 @RequestBody Task task){
        return service.updateTaskStatus(id, task);
    }

}

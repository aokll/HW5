package ru.gb.HW5.service;

import ru.gb.HW5.model.Task;
import ru.gb.HW5.model.TaskStatus;

import java.util.List;

public interface iTaskService {
    List<Task> getAllTasks();
    List<Task> getTaskByStatus(TaskStatus status);
    Task createTask(Task task);
    Task updateTaskStatus(Long id, Task task);
    void deleteTaskById(Long id);
    Task getTaskById(Long id);
}

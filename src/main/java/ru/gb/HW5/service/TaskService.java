package ru.gb.HW5.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.HW5.model.Task;
import ru.gb.HW5.model.TaskStatus;
import ru.gb.HW5.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService implements iTaskService{
    @Autowired
    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }



    @Override
    public List<Task> getTaskByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTaskStatus(Long id, Task task) {
       Task existingTask = getTaskById(id);
       existingTask.setTaskDescription(task.getTaskDescription());
       existingTask.setStatus(task.getStatus());
       existingTask.setDateOfCreation(task.getDateOfCreation());
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
    }

}

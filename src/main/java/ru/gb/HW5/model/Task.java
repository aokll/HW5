package ru.gb.HW5.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TASK_DESCRIPTION")
    private String taskDescription;//описание задачи

    @Column(name = "STATUS")
    private TaskStatus status;//статус задачи

    @Column(name = "DATA_OF_CREATION")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateOfCreation;//дата
}

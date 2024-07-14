package com.example.todoserver.service;

import com.example.todoserver.constants.TaskStatus;
import com.example.todoserver.persist.TaskRepository;
import com.example.todoserver.persist.entity.TaskEntity;
import com.example.todoserver.web.model.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task add(String title, String description, LocalDate dueDate) {
        var entity = TaskEntity.builder()
                .title(title)
                .description(description)
                .dueDate(Date.valueOf(dueDate))
                .status(TaskStatus.TODO)
                .build();
        var saved = taskRepository.save(entity);
        return entityToObject(saved);
    }

    public List<Task> getAll() {
        return taskRepository.findAll().stream()
                .map(this::entityToObject)
                .toList();
    }

    public List<Task> getByDueDate(String dueDate) {
        return taskRepository.findAllByDueDate(Date.valueOf(dueDate)).stream()
                .map(this::entityToObject)
                .toList();
    }

    public List<Task> getByStatus(TaskStatus status) {
        return taskRepository.findAllByStatus(status).stream()
                .map(this::entityToObject)
                .toList();
    }

    public Task getOne(Long id){
        var entity = getById(id);
        return entityToObject(entity);
    }
    private TaskEntity getById(Long id){
        return taskRepository.findById(String.valueOf(id)).orElseThrow(
                () -> new IllegalArgumentException(String.format("not exists task id [%d]", id))
        );
    }

    private Task entityToObject(TaskEntity e) {
        return Task.builder()
                .id(e.getId())
                .title(e.getTitle())
                .description(e.getDescription())
                .status(e.getStatus())
                .dueDate(e.getDueDate().toString())
                .createdAt(e.getCreatedAt().toLocalDateTime())
                .updatedAt(e.getUpdatedAt().toLocalDateTime())
                .build();
    }


}

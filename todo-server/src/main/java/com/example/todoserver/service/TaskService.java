package com.example.todoserver.service;

import com.example.todoserver.constants.TaskStatus;
import com.example.todoserver.persist.TaskRepository;
import com.example.todoserver.persist.entity.TaskEntity;
import com.example.todoserver.web.model.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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

    public Task update(Long id, String title, String description, LocalDate dueDate) {
        var exists = getById(id);
        exists.setTitle(Strings.isEmpty(title) ?
                exists.getTitle() : title);
        exists.setDescription(Strings.isEmpty(description) ?
                exists.getDescription() : description);
        exists.setDueDate(Objects.isNull(dueDate) ?
                exists.getDueDate() : Date.valueOf(dueDate));

        var updated = taskRepository.save(exists);
        return entityToObject(updated);
    }

    public Task updateStatus(Long id, TaskStatus status) {
        var entity = getById(id);
        entity.setStatus(status);

        var saved = taskRepository.save(entity);
        return entityToObject(saved);
    }

    public boolean delete(Long id) {
        try {
            this.taskRepository.deleteById(String.valueOf(id));
        } catch (Exception e) {
            log.error("an error occurred while deleting [{}]", e.toString());
            return false;
        }
        return true;
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

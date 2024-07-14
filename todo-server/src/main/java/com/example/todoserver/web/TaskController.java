package com.example.todoserver.web;

import com.example.todoserver.constants.TaskStatus;
import com.example.todoserver.service.TaskService;
import com.example.todoserver.web.model.Task;
import com.example.todoserver.web.vo.TaskRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The type Task controller.
 */
@Slf4j
@Controller
@RequestMapping("tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;


    /**
     * Create task response entity.
     * 새로운 할 일 추가
     *
     * @param req 추가하고자 하는 할 일
     * @return 추가된 할 일
     */
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskRequest req) {
        var result = taskService.add(req.getTitle(),
                req.getDescription(),
                req.getDueDate());

        return ResponseEntity.ok(result);
    }

    /**
     * Gets tasks.
     * 특정 마감일에 해당하는 할일 목록을 반환
     *
     * @param dueDate 할일의 마김일
     * @return 마감일에 해당하는 할일 목록
     */
    @GetMapping
    public ResponseEntity<List<Task>> getTasks(Optional<String> dueDate) {
        List<Task> result;
        if (dueDate.isPresent()) {
            result = taskService.getByDueDate(dueDate.get());
        } else {
            result = taskService.getAll();
        }
        return ResponseEntity.ok(result);
    }

    /**
     * Fetch one task response entity.
     * 특정 ID에 해당하는 할일을 조회
     *
     * @param id 할일 ID
     * @return ID에 해당하는 할일 객체
     */
    @GetMapping("/{id}")
    public ResponseEntity<Task> fetchOneTask(@PathVariable Long id) {
        var result = taskService.getOne(id);
        return ResponseEntity.ok(result);
    }

    /**
     * Gets by status.
     * 특정 상태에 해당하는 할일 목록을 반환
     *
     * @param status 할일 상태
     * @return 상태에 해당하는 할 일 목록
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getByStatus(@PathVariable TaskStatus status) {
        var result = taskService.getByStatus(status);
        return ResponseEntity.ok(result);
    }


}

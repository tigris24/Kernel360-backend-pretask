package com.example.todoserver.web;

import com.example.todoserver.service.TaskService;
import com.example.todoserver.web.model.Task;
import com.example.todoserver.web.vo.TaskRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

package work.lince.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.lince.commons.log.LogExecutionTime;
import work.lince.project.model.Task;
import work.lince.project.service.TaskService;

@LogExecutionTime
@RestController
@RequestMapping(path = "/tasks")
public class TaskController {

    @Autowired
    protected TaskService taskService;

    @PostMapping
    public Task create(@RequestBody @Validated Task task) {
        return taskService.create(task);
    }

    @GetMapping
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable Long id) {
        return taskService.findById(id);
    }
}

package work.lince.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import work.lince.commons.log.LogExecutionTime;
import work.lince.project.model.Project;
import work.lince.project.service.ProjectService;

import java.util.List;

@LogExecutionTime
@RestController
@RequestMapping(path = "/projects")
public class ProjectController {

    @Autowired
    protected ProjectService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(@RequestBody @Validated Project body) {
        return service.create(body);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Project> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Project findById(@PathVariable("id") final Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable("id") final Long id) {
        service.remove(id);
    }

}
package work.lince.project.controller;

import org.springframework.web.bind.annotation.*;
import work.lince.project.model.Project;
import work.lince.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @author pzatta
 */

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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable("id") final Long id) {
        service.remove(id);
    }

}
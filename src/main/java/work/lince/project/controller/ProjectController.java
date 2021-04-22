package work.lince.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import work.lince.commons.log.LogExecutionTime;
import work.lince.project.model.Project;
import work.lince.project.service.ProjectService;

import java.util.List;

@LogExecutionTime
@RestController
@RequestMapping(path = "/projects")
@Api(value = "Lince Project")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    protected ProjectService service;

    @PostMapping
    @ApiOperation(value = "Cadastra um novo projeto")
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(@RequestBody @Validated Project body) {
        return service.create(body);
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todos os projetos")
    @ResponseStatus(HttpStatus.OK)
    public List<Project> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Retorna um projeto")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Project> findById(@PathVariable("id") final Long id) {
        Project obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui um projeto")
    @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable("id") final Long id) {
        service.remove(id);
    }

}

package work.lince.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import work.lince.commons.log.LogExecutionTime;
import work.lince.project.model.Tasks;
import work.lince.project.service.TaskService;

import java.net.URI;
import java.util.List;

@LogExecutionTime
@RestController
@RequestMapping(path = "/projects/tasks")
@Api(value = "Lince Project")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    protected TaskService service;

    @PostMapping
    @ApiOperation(value = "Cadastra uma nova tarefa")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Tasks> create(@RequestParam(value = "project",defaultValue = "0")long id_proj,
                                        @RequestBody @Validated  Tasks obj){
        Tasks newObj = service.create(id_proj, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("projects/tasks/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todas as tarefas")
    @ResponseStatus(HttpStatus.OK)
    public List<Tasks> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna uma tarefa")
    @ResponseStatus(HttpStatus.OK)
    public Tasks findById(@PathVariable("id") final Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui uma tarefa")
    @ResponseStatus(HttpStatus.OK)
    public void removeTask(@PathVariable("id") final Long id) {
        service.remove(id);
    }

}

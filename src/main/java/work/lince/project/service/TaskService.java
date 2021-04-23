package work.lince.project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.lince.commons.authentication.AuthenticationService;
import work.lince.commons.exception.NotFoundException;
import work.lince.project.model.Project;
import work.lince.project.model.Tasks;
import work.lince.project.repository.TaskRepository;

import java.util.List;

@Slf4j
@Service
public class TaskService {

    @Autowired
    protected TaskRepository repository;

    @Autowired ProjectService projectService;

    @Autowired
    protected AuthenticationService authenticationService;


    public Tasks create(long id_proj, Tasks obj){
        obj.setId(null);
        Project proj = projectService.findById(id_proj);
        obj.setProject(proj);
        return repository.save(obj);
    }


    public List<Tasks> findAll() {
        return repository.findAll();
    }


    public Tasks findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    public void remove(Long id) {
        Tasks tasks = repository.findById(id)
                .orElseThrow(() -> new NotFoundException());
        repository.delete(tasks);
    }

}

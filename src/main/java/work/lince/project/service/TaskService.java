package work.lince.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import work.lince.commons.authentication.AuthenticationService;
import work.lince.project.model.Task;
import work.lince.project.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    protected TaskRepository repository;

    @Autowired
    protected AuthenticationService authenticationService;

    public Task create(Task task) {
        task.setOwner(authenticationService.getAuthenticatedUser());
        return repository.save(task);
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

}

package work.lince.project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.lince.commons.authentication.AuthenticationService;
import work.lince.commons.exception.NotFoundException;
import work.lince.project.model.Project;
import work.lince.project.model.ProjectStatus;
import work.lince.project.repository.ProjectRepository;

import java.util.List;

@Slf4j
@Service
public class ProjectService {

    @Autowired
    protected ProjectRepository repository;

    @Autowired
    protected AuthenticationService authenticationService;

    public Project create(Project project) {
        project.setOwner(authenticationService.getAuthenticatedUser());
        project.setStatus(ProjectStatus.CREATED);
        return repository.save(project);
    }

    public List<Project> findAll() {
        return repository.findAll();
    }


    public Project findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    public void remove(Long id) {
        Project project = repository.findById(id)
                .orElseThrow(() -> new NotFoundException());
        repository.delete(project);
    }

}
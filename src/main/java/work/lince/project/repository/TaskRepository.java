package work.lince.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import work.lince.project.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}

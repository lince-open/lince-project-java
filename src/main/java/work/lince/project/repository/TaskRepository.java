package work.lince.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work.lince.project.model.Tasks;

public interface TaskRepository extends JpaRepository<Tasks, Long> {
}


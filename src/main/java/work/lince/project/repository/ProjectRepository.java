package work.lince.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work.lince.project.model.Project;
/**
 * @author pzatta
 */

public interface ProjectRepository extends JpaRepository<Project, Long> {
}


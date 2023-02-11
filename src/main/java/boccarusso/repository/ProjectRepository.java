package boccarusso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import boccarusso.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, String> {
}

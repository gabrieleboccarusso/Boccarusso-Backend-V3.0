package boccarusso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boccarusso.repository.ProjectRepository;
import boccarusso.entity.Project;

@Service
public class ProjectService {
 @Autowired
 private ProjectRepository projectRepository;

 public Iterable<Project> getAllProjects() {
  return this.projectRepository.findAll();
 }
}

package boccarusso.service;

import static boccarusso.Functions.sanitize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boccarusso.entity.Project;
import boccarusso.repository.ProjectRepository;

@Service
public class ProjectService {
 @Autowired
 private ProjectRepository projectRepository;

 public Iterable<Project> getAllProjects() {
  return this.projectRepository.findAll();
 }

 public void postProject(Project p) {
  // TODO
  // check if project already exists
  // return responseEntity

  p.setSlug(sanitize(p.getTitle()));
  this.projectRepository.save(p);
 }
}

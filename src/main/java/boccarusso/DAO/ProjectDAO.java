package boccarusso.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import boccarusso.entity.Project;
import boccarusso.repository.ProjectRepository;

@Component
public class ProjectDAO implements DAO<Project> {
 @Autowired
 ProjectRepository projectRepository;

 public Optional<Project> get(String id) {
  return this.projectRepository.findById(id);
 }

 public Iterable<Project> getAll() {
  return this.projectRepository.findAll();
 }

 public boolean delete(String id) {
  boolean flag = true;

  this.projectRepository.deleteById(id);

  if (this.projectRepository.existsById(id)) {
   flag = false;
  }

  return flag;
 }

 public boolean put(Project p) {
  // TODO: make behavior that checks if it is actually updated
  this.projectRepository.save(p);
  return true;
 }

 public Project post(Project p) {
  // TODO: make behavior that checks if it is actually saved
  return this.projectRepository.save(p);
 }

 public boolean exists(String id) {
  boolean flag = false;

  if (this.projectRepository.existsById(id)) {
   flag = true;
  }

  return flag;
 }

}

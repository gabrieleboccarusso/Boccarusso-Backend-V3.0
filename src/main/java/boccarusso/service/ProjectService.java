package boccarusso.service;

import static boccarusso.Functions.sanitize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boccarusso.DAO.ProjectDAO;
import boccarusso.entity.Project;

@Service
public class ProjectService {
 @Autowired
 private ProjectDAO dao;

 public Iterable<Project> getAllProjects() {
  return this.dao.getAll();
 }

 public ResponseEntity<Project> postProject(Project p) {
  // TODO: accept project DTO as argument
  Project result = null;
  HttpStatus status = HttpStatus.BAD_REQUEST;

  p.setSlug(sanitize(p.getTitle()));

  if (!this.dao.exists(p.getSlug())) {
   result = this.dao.post(p);
   status = HttpStatus.OK;
  }

  return new ResponseEntity<Project>(result, status);
 }
}

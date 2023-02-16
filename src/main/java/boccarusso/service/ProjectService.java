package boccarusso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boccarusso.DAO.ProjectDAO;
import boccarusso.DTO.ProjectDTO;
import boccarusso.entity.Project;

@Service
public class ProjectService {
 @Autowired
 private ProjectDAO dao;

 public Iterable<Project> getAllProjects() {
  return this.dao.getAll();
 }

 public ResponseEntity<Project> postProject(ProjectDTO dto) {
  Project result = new Project(dto);
  HttpStatus status = HttpStatus.BAD_REQUEST;

  if (!this.dao.exists(result.getSlug())) {
   result = this.dao.post(result);
   status = HttpStatus.OK;
  } else {
   result = null;
  }

  return new ResponseEntity<Project>(result, status);
 }
}

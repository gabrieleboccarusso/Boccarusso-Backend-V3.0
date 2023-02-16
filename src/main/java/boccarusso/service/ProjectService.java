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

 public ResponseEntity<Project> getProjectById(String id) {
  HttpStatus status = HttpStatus.NOT_FOUND;
  Project result = null;

  if (this.dao.exists(id)) {
   status = HttpStatus.OK;
   result = this.dao.getExisting(id);
  }

  return new ResponseEntity<Project>(result, status);
 }

 public ResponseEntity<Project> deleteProject(String id) {
  HttpStatus status = HttpStatus.NOT_FOUND;

  if (this.dao.exists(id)) {
   this.dao.delete(id);
   status = HttpStatus.OK;
  }

  return new ResponseEntity<>(status);
 }

 public ResponseEntity<Project> patchProjectTitle(String id, String new_title) {
  HttpStatus status = HttpStatus.NOT_FOUND;
  Project project = null;

  if (this.dao.exists(id)) {
   project = this.dao.getExisting(id);
   this.dao.deleteExisting(id);
   project.setSlug(new_title);
   project.setTitle(new_title);
   this.dao.post(project);
   status = HttpStatus.OK;
  }

  return new ResponseEntity<Project>(project, status);
 }
}

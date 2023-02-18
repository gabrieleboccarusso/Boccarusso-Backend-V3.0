package boccarusso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boccarusso.DAO.ProjectDAO;
import boccarusso.DTO.ProjectDTO;
import boccarusso.entity.Project;

@Service
public class ProjectService extends SuperService<Project> {
 @Autowired
 private ProjectDAO dao;

 public ResponseEntity<Project> post(ProjectDTO dto) {
  Project project = new Project(dto);

  return super.post(project, project.getSlug());
 }

 public ResponseEntity<Project> patchProjectTitle(String id, String new_title) {
  HttpStatus status = HttpStatus.NOT_FOUND;
  Project project = null;

  if (this.dao.exists(id)) {
   project = this.dao.getExisting(id);
   this.dao.deleteExisting(id);
   project.setSlug(new_title);
   project.setTitle(new_title);
   this.dao.save(project);
   status = HttpStatus.OK;
  }

  return new ResponseEntity<Project>(project, status);
 }

 public ResponseEntity<Project> patchProjectIntro(String id, String new_intro) {
  HttpStatus status = HttpStatus.NOT_FOUND;
  Project project = null;

  if (this.dao.exists(id)) {
   project = this.dao.getExisting(id);
   project.setIntro(new_intro);
   this.dao.save(project);
   status = HttpStatus.OK;
  }

  return new ResponseEntity<Project>(project, status);
 }

 public ResponseEntity<Project> patchProjectImage(String id, String image) {
  HttpStatus status = HttpStatus.NOT_FOUND;
  Project project = null;

  if (this.dao.exists(id)) {
   project = this.dao.getExisting(id);
   project.setImage(image);
   this.dao.save(project);
   status = HttpStatus.OK;
  }

  return new ResponseEntity<Project>(project, status);
 }

 public ResponseEntity<Project> patchProjectRepo(String id, String repo) {
  HttpStatus status = HttpStatus.NOT_FOUND;
  Project project = null;

  if (this.dao.exists(id)) {
   project = this.dao.getExisting(id);
   project.setRepo(repo);
   this.dao.save(project);
   status = HttpStatus.OK;
  }

  return new ResponseEntity<Project>(project, status);
 }
}

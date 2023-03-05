package boccarusso.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boccarusso.DTO.ProjectDTO;
import boccarusso.entity.Project;

@Service
public class ProjectService extends SuperService<Project, String> {
 public ResponseEntity<Project> post(ProjectDTO dto) {
  Project project = new Project(dto);

  return super.post(project, project.getSlug());
 }

 public ResponseEntity<Project> patchProjectTitle(String id, String new_title) {
  return super.patch(id, (Project p) -> {
   this.dao.deleteExisting(id);
   p.setSlug(new_title);
   p.setTitle(new_title);
   return p;
  });
 }

 public ResponseEntity<Project> patchProjectIntro(String id, String new_intro) {
  return super.patch(id, (Project p) -> {
   p.setIntro(new_intro);
   return p;
  });
 }

 public ResponseEntity<Project> patchProjectImage(String id, String image) {
  return super.patch(id, (Project p) -> {
   p.setImage(image);
   return p;
  });
 }

 public ResponseEntity<Project> patchProjectRepo(String id, String repo) {
  return super.patch(id, (Project p) -> {
   p.setRepo(repo);
   return p;
  });
 }
}

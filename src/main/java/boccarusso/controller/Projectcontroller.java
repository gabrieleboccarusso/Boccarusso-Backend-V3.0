package boccarusso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import boccarusso.DTO.ProjectDTO;
import boccarusso.entity.Project;
import boccarusso.service.ProjectService;

@RestController
@RequestMapping("/project")
public class Projectcontroller {
 @Autowired
 private ProjectService projectService;

 @GetMapping
 Iterable<Project> getAll() {
  return this.projectService.getAllProjects();
 }

 @PostMapping
 ResponseEntity<Project> post(@RequestBody ProjectDTO p) {
  return this.projectService.postProject(p);
 }

 @GetMapping("/{slug}")
 ResponseEntity<Project> getById(@PathVariable String slug) {
  return this.projectService.getProjectById(slug);
 }

 @DeleteMapping("/{slug}")
 ResponseEntity<Project> deleteById(@PathVariable String slug) {
  return this.projectService.deleteProject(slug);
 }
}

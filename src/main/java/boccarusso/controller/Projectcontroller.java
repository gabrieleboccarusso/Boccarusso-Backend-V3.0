package boccarusso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
 ResponseEntity<Project> post(@RequestBody Project p) {
  return this.projectService.postProject(p);
 }
}

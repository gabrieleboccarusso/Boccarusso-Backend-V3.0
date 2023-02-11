package boccarusso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import boccarusso.entity.Project;
import boccarusso.service.ProjectService;

@RestController
@RequestMapping("project")
public class Projectcontroller {
 @Autowired
 private ProjectService projectService;

 @GetMapping
 Iterable<Project> getAll() {
  return this.projectService.getAllProjects();
 }
}

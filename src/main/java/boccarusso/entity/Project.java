package boccarusso.entity;

import boccarusso.DTO.ProjectDTO;
import static boccarusso.Functions.sanitize;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project {
 @Id
 private String slug;
 private String title;
 private String intro;
 private String image;
 private String repo;

 public Project(ProjectDTO dto) {
  this.slug = sanitize(dto.getTitle());
  this.image = dto.getImage();
  this.intro = dto.getIntro();
  this.title = dto.getTitle();
  this.repo = dto.getRepo();
 }
}

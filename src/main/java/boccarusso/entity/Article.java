package boccarusso.entity;

import static boccarusso.Functions.getCurrentDate;
import static boccarusso.Functions.sanitize;

import boccarusso.DTO.ArticleDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Article {
 @Id
 private String slug;
 private String title;
 private String intro;
 private String image;
 private String content;
 private String creationDate;
 private String lastUpdate;

 public Article(ArticleDTO dto) {
  this.slug = sanitize(dto.getTitle());
  this.title = dto.getTitle();
  this.intro = dto.getIntro();
  this.image = dto.getImage();
  this.content = dto.getContent();
  this.setCreationDate();
  this.setLastUpdate();
 }

 public void setCreationDate() {
  this.creationDate = getCurrentDate();
 }

 public void setLastUpdate() {
  this.lastUpdate = getCurrentDate();
 }
}

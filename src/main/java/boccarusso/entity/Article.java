package boccarusso.entity;

import static boccarusso.Functions.getCurrentDate;
import static boccarusso.Functions.sanitize;

import java.util.ArrayList;
import java.util.List;

import boccarusso.DTO.ArticleDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

 @ManyToMany(fetch = FetchType.EAGER)
 @JoinTable(name = "article_tag", joinColumns = @JoinColumn(name = "article_slug"), inverseJoinColumns = @JoinColumn(name = "tag_slug"))
 private List<Tag> tag = new ArrayList<>();

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

 public void addTag(Tag t) {
  this.tag.add(t);
 }
}

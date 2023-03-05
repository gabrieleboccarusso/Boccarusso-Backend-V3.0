package boccarusso.entity;

import static boccarusso.Functions.getCurrentDate;
import static boccarusso.Functions.sanitize;
import boccarusso.DTO.ArticleDTO;

import java.util.HashSet;
import java.util.Set;

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
 private String tagline;
 private String image;
 private String content;
 private String creationDate;
 private String lastUpdate;

 @ManyToMany(fetch = FetchType.EAGER)
 @JoinTable(name = "article_tag", joinColumns = @JoinColumn(name = "article_slug"), inverseJoinColumns = @JoinColumn(name = "tag_slug"))
 private Set<Tag> tag = new HashSet<>();

 public Article(ArticleDTO dto) {
  this.setSlug(dto.getTitle());
  this.title = dto.getTitle();
  this.tagline = dto.getTagline();
  this.image = dto.getImage();
  this.content = dto.getContent();
  this.setCreationDate();
  this.setLastUpdate();
 }

 public void setSlug(String s) {
  this.slug = sanitize(s);
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

 public void removeTag(Tag t) {
  this.tag.remove(t);
 }
}

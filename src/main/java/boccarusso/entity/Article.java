package boccarusso.entity;

import static boccarusso.Functions.getCurrentDate;

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
 private String lastUpdate = null;

 public void setCreationDate() {
  this.creationDate = getCurrentDate();
 }

 public void setLastUpdate() {
  this.lastUpdate = getCurrentDate();
 }
}

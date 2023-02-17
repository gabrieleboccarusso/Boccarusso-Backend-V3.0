package boccarusso.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static boccarusso.Functions.sanitize;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tag {
 @Id
 private String slug;
 private String name;

 public void setSlug(String s) {
  this.slug = sanitize(s);
 }
}

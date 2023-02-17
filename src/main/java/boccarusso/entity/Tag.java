package boccarusso.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static boccarusso.Functions.sanitize;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tag {
 private String slug;
 private String name;

 public void setSlug(String s) {
  this.slug = sanitize(s);
 }
}

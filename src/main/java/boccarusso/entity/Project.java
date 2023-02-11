package boccarusso.entity;

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
}

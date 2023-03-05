package boccarusso.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
 private String title;
 private String tagline;
 private String image;
 private String repo;
}

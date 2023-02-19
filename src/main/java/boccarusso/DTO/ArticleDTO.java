package boccarusso.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {
 private String title;
 private String intro;
 private String image;
 private String content;
 private List<String> tagSlugs;
}
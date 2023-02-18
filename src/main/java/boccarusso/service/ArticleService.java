package boccarusso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boccarusso.DAO.ArticleDAO;
import boccarusso.DTO.ArticleDTO;
import boccarusso.entity.Article;

@Service
public class ArticleService extends SuperService<Article> {
 @Autowired
 ArticleDAO ArticleDao;

 public ResponseEntity<Article> post(ArticleDTO dto) {
  Article article = new Article(dto);

  return super.post(article, article.getSlug());
 }
}

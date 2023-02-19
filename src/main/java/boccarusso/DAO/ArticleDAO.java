package boccarusso.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import boccarusso.entity.Article;
import boccarusso.repository.ArticleRepository;

@Component
public class ArticleDAO extends SuperDAO<Article> {
 @Autowired
 private ArticleRepository articleRepository;

 public Iterable<Article> getArticlesByTitle(String title) {
  return this.articleRepository.findByTitleContaining(title);
 }
}

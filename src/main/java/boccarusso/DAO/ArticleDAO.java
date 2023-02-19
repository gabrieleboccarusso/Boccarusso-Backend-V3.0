package boccarusso.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import boccarusso.entity.Article;
import boccarusso.entity.Tag;
import boccarusso.repository.ArticleRepository;

@Component
public class ArticleDAO extends SuperDAO<Article> {
 @Autowired
 private ArticleRepository articleRepository;
 @Autowired
 private TagDAO tagDao;

 public Iterable<Article> getArticlesByTitle(String title) {
  return this.articleRepository.findByTitleContaining(title);
 }

 public Optional<Tag> checkTagExistence(String id) {
  return this.tagDao.get(id);
 }

 public Iterable<Article> getArticlesWithTag(String tag_slug) {
  return this.articleRepository.findByTagSlug(tag_slug);
 }
}

package boccarusso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boccarusso.DAO.ArticleDAO;
import boccarusso.DTO.ArticleDTO;
import boccarusso.entity.Article;
import boccarusso.entity.Tag;

@Service
public class ArticleService extends SuperService<Article> {
 @Autowired
 ArticleDAO ArticleDao;

 private void tagsValidator(Article a, List<String> tags) {
  Optional<Tag> tag;

  for (int i = 0; i < tags.size(); ++i) {
   tag = this.ArticleDao.checkTagExistence(tags.get(i));

   if (!tag.isEmpty()) {
    a.addTag(tag.get());
   }
  }
 }

 public ResponseEntity<Article> post(ArticleDTO dto) {
  Article article = new Article(dto);
  this.tagsValidator(article, dto.getTagSlugs());

  return super.post(article, article.getSlug());
 }

 public Iterable<Article> getByTitle(String title) {
  return this.ArticleDao.getArticlesByTitle(title);
 }

 public Iterable<Article> getWithTag(String tag_slug) {
  return this.ArticleDao.getArticlesWithTag(tag_slug);
 }
}

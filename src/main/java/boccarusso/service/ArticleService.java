package boccarusso.service;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boccarusso.DAO.ArticleDAO;
import boccarusso.DAO.TagDAO;
import boccarusso.DTO.ArticleDTO;
import boccarusso.entity.Article;
import boccarusso.entity.Tag;

@Service
public class ArticleService extends SuperService<Article, String> {
 @Autowired
 TagDAO tagDao;

 @Autowired
 ArticleDAO articleDao;

 private void addTags(Article a, HashSet<String> tags) {
  Optional<Tag> tag;

  for (String slug : tags) {
   tag = this.tagDao.get(slug);

   if (!tag.isEmpty()) {
    a.addTag(tag.get());
   }
  }
 }

 private void removeTags(Article a, HashSet<String> tags) {
  Optional<Tag> tag;

  for (String slug : tags) {
   tag = this.tagDao.get(slug);

   if (!tag.isEmpty()) {
    a.removeTag(tag.get());
   }
  }
 }

 public Iterable<Article> getAll(Integer page, Integer size) {
  // if they are both null then get all
  Iterable<Article> result;
  if (page == null && size == null) {
   result = super.getAll();
  } else {
   // ternary operator used to set default values
   result = super.getAll(
    (page == null) ? 0 : page.intValue(),
    (size == null) ? 2 : size.intValue()
   );
  }

  return result;
 }

 public ResponseEntity<Article> post(ArticleDTO dto) {
  Article article = new Article(dto);
  this.addTags(article, dto.getTagSlugs());

  return super.post(article, article.getSlug());
 }

 public Iterable<Article> getByTitle(String title) {
  return this.articleDao.getArticlesByTitle(title);
 }

 public Iterable<Article> getWithTag(String tag_slug) {
  return this.articleDao.getArticlesWithTag(tag_slug);
 }

 public ResponseEntity<Article> patchArticleTitle(String id, String title) {
  return super.patch(id, (Article a) -> {
   this.articleDao.deleteExisting(id);
   a.setSlug(title);
   a.setTitle(title);
   a.setLastUpdate();
   return a;
  });
 }

 public ResponseEntity<Article> patchArticleIntro(String id, String intro) {
  return super.patch(id, (Article a) -> {
   a.setIntro(intro);
   a.setLastUpdate();
   return a;
  });
 }

 public ResponseEntity<Article> patchArticleImage(String id, String image) {
  return super.patch(id, (Article a) -> {
   a.setImage(image);
   a.setLastUpdate();
   return a;
  });
 }

 public ResponseEntity<Article> patchArticleContent(String id, String content) {
  return super.patch(id, (Article a) -> {
   a.setContent(content);
   a.setLastUpdate();
   return a;
  });
 }

 public ResponseEntity<Article> addArticleTag(String id, HashSet<String> tagSlugs) {
  // although the method is logically more adapt to a POST
  // using the patch parent method provides more flexibility
  return super.patch(id, (Article a) -> {
   this.addTags(a, tagSlugs);
   a.setLastUpdate();
   return a;
  });
 }

 public ResponseEntity<Article> removeArticleTag(String id, HashSet<String> tagSlugs) {
  return super.patch(id, (Article a) -> {
   this.removeTags(a, tagSlugs);
   return a;
  });
 }
}

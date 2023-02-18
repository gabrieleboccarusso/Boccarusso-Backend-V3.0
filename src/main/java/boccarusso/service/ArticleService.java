package boccarusso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boccarusso.DAO.ArticleDAO;
import boccarusso.entity.Article;

@Service
public class ArticleService {
 @Autowired
 ArticleDAO ArticleDao;

 public Iterable<Article> getAllArticles() {
  return this.ArticleDao.getAll();
 }
}

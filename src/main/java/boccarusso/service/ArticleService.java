package boccarusso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boccarusso.DAO.ArticleDAO;
import boccarusso.DTO.ArticleDTO;
import boccarusso.entity.Article;

@Service
public class ArticleService extends SuperService<Article> {
 @Autowired
 ArticleDAO ArticleDao;

 public ResponseEntity<Article> postArticle(ArticleDTO dto) {
  Article result = new Article(dto);
  HttpStatus status = HttpStatus.BAD_REQUEST;

  if (!this.ArticleDao.exists(result.getSlug())) {
   result = this.ArticleDao.save(result);
   status = HttpStatus.OK;
  } else {
   result = null;
  }

  return new ResponseEntity<Article>(result, status);
 }
}

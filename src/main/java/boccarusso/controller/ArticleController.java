package boccarusso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import boccarusso.entity.Article;
import boccarusso.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {
 @Autowired
 ArticleService articleService;

 @GetMapping
 Iterable<Article> getAllArticle() {
  return this.articleService.getAllArticles();
 }
}

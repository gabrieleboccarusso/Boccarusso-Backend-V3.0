package boccarusso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import boccarusso.DTO.ArticleDTO;
import boccarusso.entity.Article;
import boccarusso.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {
 @Autowired
 ArticleService articleService;

 @GetMapping
 Iterable<Article> getAllArticle() {
  return this.articleService.getAll();
 }

 @PostMapping
 ResponseEntity<Article> postArticle(@RequestBody ArticleDTO dto) {
  return this.articleService.post(dto);
 }

 @GetMapping("/{slug}")
 ResponseEntity<Article> getArticleById(@PathVariable String slug) {
  return this.articleService.getById(slug);
 }

 @DeleteMapping("/{slug}")
 ResponseEntity<Article> deleteArticle(@PathVariable String slug) {
  return this.articleService.delete(slug);
 }

 @GetMapping("/title")
 Iterable<Article> getArticleByTitle(@RequestParam String value) {
  return this.articleService.getByTitle(value);
 }
}

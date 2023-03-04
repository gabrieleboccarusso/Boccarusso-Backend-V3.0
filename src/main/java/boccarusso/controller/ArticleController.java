package boccarusso.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
 Iterable<Article> getAllArticle(
  @RequestParam(required = false) Integer page,
  @RequestParam(required = false) Integer size
 ) {
  return this.articleService.getAll(page, size);
 }

 @GetMapping("/total")
 long getTotalNum() {
  return this.articleService.getTotalNum();
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

 @GetMapping("/tag")
 Iterable<Article> getArticlewithTagSlug(@RequestParam String value) {
  return this.articleService.getWithTag(value);
 }

 @PatchMapping("/{slug}/title")
 ResponseEntity<Article> patchArticleTitle(@PathVariable String slug, @RequestParam String value) {
  return this.articleService.patchArticleTitle(slug, value);
 }

 @PatchMapping("/{slug}/intro")
 ResponseEntity<Article> patchArticleIntro(@PathVariable String slug, @RequestParam String value) {
  return this.articleService.patchArticleIntro(slug, value);
 }

 @PatchMapping("/{slug}/image")
 ResponseEntity<Article> patchArticleImage(@PathVariable String slug, @RequestParam String value) {
  return this.articleService.patchArticleImage(slug, value);
 }

 @PatchMapping("/{slug}/content")
 ResponseEntity<Article> patchArticleContent(@PathVariable String slug, @RequestParam String value) {
  return this.articleService.patchArticleContent(slug, value);
 }

 @PostMapping("/{slug}/tag")
 ResponseEntity<Article> postArticleTag(@PathVariable String slug, @RequestBody HashSet<String> tags) {
  return this.articleService.addArticleTag(slug, tags);
 }

 @DeleteMapping("/{slug}/tag")
 ResponseEntity<Article> deleteArticleTag(@PathVariable String slug, @RequestBody HashSet<String> tags) {
  return this.articleService.removeArticleTag(slug, tags);
 }
}

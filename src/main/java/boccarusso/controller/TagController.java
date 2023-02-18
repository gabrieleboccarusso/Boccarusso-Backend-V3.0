package boccarusso.controller;

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

import boccarusso.DTO.TagDTO;
import boccarusso.entity.Tag;
import boccarusso.service.TagService;

@RestController
@RequestMapping("/tag")
public class TagController {
 @Autowired
 private TagService tagService;

 @GetMapping
 Iterable<Tag> getAllTags() {
  return this.tagService.getAll();
 }

 @PostMapping
 ResponseEntity<Tag> postTag(@RequestBody TagDTO t) {
  return this.tagService.postTag(t);
 }

 @GetMapping("/{slug}")
 ResponseEntity<Tag> getTagById(@PathVariable String slug) {
  return this.tagService.getById(slug);
 }

 @DeleteMapping("/{slug}")
 ResponseEntity<Tag> deleteTag(@PathVariable String slug) {
  return this.tagService.delete(slug);
 }

 @PatchMapping("/{slug}/name")
 ResponseEntity<Tag> patchTagName(@PathVariable String slug, @RequestParam String value) {
  return this.tagService.PatchTagName(slug, value);
 }
}

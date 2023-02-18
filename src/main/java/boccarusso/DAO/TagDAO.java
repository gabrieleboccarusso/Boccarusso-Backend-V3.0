package boccarusso.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import boccarusso.entity.Tag;
import boccarusso.repository.TagRepository;

@Component
public class TagDAO implements DAO<Tag> {
 @Autowired
 private TagRepository tagRepository;

 public Optional<Tag> get(String id) {
  return this.tagRepository.findById(id);
 }

 public Iterable<Tag> getAll() {
  return this.tagRepository.findAll();
 }

 public Tag getExisting(String id) {
  return this.get(id).get();
 }

 public Tag save(Tag t) {
  return this.tagRepository.save(t);
 }

 public boolean exists(String id) {
  return this.tagRepository.existsById(id);
 }

 public boolean delete(String id) {
  boolean flag = false;

  if (this.exists(id)) {
   this.tagRepository.deleteById(id);
   flag = true;
  }

  return flag;
 }

 public void deleteExisting(String id) {
  this.tagRepository.deleteById(id);
 }
}

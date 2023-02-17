package boccarusso.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import boccarusso.entity.Tag;
import boccarusso.repository.TagRepository;

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
  boolean flag = true;

  this.tagRepository.deleteById(id);

  if (this.exists(id)) {
   flag = false;
  }

  return flag;
 }

 public void deleteExisting(String id) {
  this.tagRepository.deleteById(id);
 }
}

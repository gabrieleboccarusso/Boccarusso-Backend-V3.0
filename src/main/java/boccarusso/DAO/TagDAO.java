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

 public Tag getExisting(String id) {
  return this.get(id).get();
 }

}

package boccarusso.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boccarusso.DTO.TagDTO;
import boccarusso.entity.Tag;

@Service
public class TagService extends SuperService<Tag, String> {
 public ResponseEntity<Tag> post(TagDTO tagDto) {
  Tag tag = new Tag(tagDto);

  return super.post(new Tag(tagDto), tag.getSlug());
 }

 public ResponseEntity<Tag> PatchTagName(String id, String value) {
  return super.patch(id, (Tag t) -> {
   this.dao.deleteExisting(id);
   t.setName(value);
   t.setSlug(value);
   return t;
  });
 }
}

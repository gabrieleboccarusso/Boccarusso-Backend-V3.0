package boccarusso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boccarusso.DAO.TagDAO;
import boccarusso.DTO.TagDTO;
import boccarusso.entity.Tag;

@Service
public class TagService extends SuperService<Tag> {
 @Autowired
 private TagDAO tagDao;

 public ResponseEntity<Tag> post(TagDTO tagDto) {
  Tag tag = new Tag(tagDto);

  return super.post(tag, tag.getSlug());
 }

 public ResponseEntity<Tag> PatchTagName(String id, String value) {
  return super.patch(id, (Tag t) -> {
   this.tagDao.deleteExisting(id);
   t.setName(value);
   t.setSlug(value);
   return t;
  });
 }
}

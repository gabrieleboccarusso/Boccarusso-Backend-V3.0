package boccarusso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
  HttpStatus status = HttpStatus.NOT_FOUND;
  Tag tag = null;

  if (this.tagDao.exists(id)) {
   tag = this.tagDao.getExisting(id);
   this.tagDao.deleteExisting(id);
   tag.setName(value);
   tag.setSlug(value);
   this.tagDao.save(tag);
   status = HttpStatus.OK;
  }

  return new ResponseEntity<Tag>(tag, status);
 }
}

package boccarusso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import boccarusso.DAO.TagDAO;
import boccarusso.DTO.TagDTO;
import boccarusso.entity.Tag;

@Service
public class TagService {
 @Autowired
 private TagDAO tagDao;

 public Iterable<Tag> getAllTags() {
  return this.tagDao.getAll();
 }

 public ResponseEntity<Tag> postTag(TagDTO tagDto) {
  Tag result = new Tag(tagDto);
  HttpStatus status = HttpStatus.BAD_REQUEST;

  if (!this.tagDao.exists(result.getSlug())) {
   result = this.tagDao.save(result);
   status = HttpStatus.OK;
  } else {
   result = null;
  }

  return new ResponseEntity<Tag>(result, status);
 }
}

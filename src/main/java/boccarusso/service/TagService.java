package boccarusso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boccarusso.DAO.TagDAO;
import boccarusso.entity.Tag;

@Service
public class TagService {
 @Autowired
 private TagDAO tagDao;

 public Iterable<Tag> getAllTags() {
  return this.tagDao.getAll();
 }
}

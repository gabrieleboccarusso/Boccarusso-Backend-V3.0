package boccarusso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import boccarusso.DAO.SuperDAO;

public class SuperService<T> {
 @Autowired
 private SuperDAO<T> dao;

 public Iterable<T> getAll() {
  return this.dao.getAll();
 }

 public ResponseEntity<T> getById(String id) {
  T result = null;
  HttpStatus status = HttpStatus.BAD_REQUEST;

  if (this.dao.exists(id)) {
   result = this.dao.getExisting(id);
   status = HttpStatus.OK;
  }

  return new ResponseEntity<T>(result, status);
 }

 public ResponseEntity<T> post(T t, String id) {
  HttpStatus status = HttpStatus.BAD_REQUEST;

  if (!this.dao.exists(id)) {
   this.dao.save(t);
   status = HttpStatus.OK;
  } else {
   t = null;
  }

  return new ResponseEntity<T>(t, status);
 }

 public ResponseEntity<T> delete(String id) {
  HttpStatus status = HttpStatus.NOT_FOUND;

  if (this.dao.delete(id)) {
   status = HttpStatus.OK;
  }

  return new ResponseEntity<>(status);
 }
}

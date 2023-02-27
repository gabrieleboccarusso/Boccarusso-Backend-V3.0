package boccarusso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import boccarusso.DAO.SuperDAO;

public class SuperService<T, I> {
 @Autowired
 private SuperDAO<T, I> dao;

 public Iterable<T> getAll() {
  return this.dao.getAll();
 }

 public ResponseEntity<T> getById(I id) {
  T result = null;
  HttpStatus status = HttpStatus.NOT_FOUND;

  if (this.dao.exists(id)) {
   result = this.dao.getExisting(id);
   status = HttpStatus.OK;
  }

  return new ResponseEntity<T>(result, status);
 }

 public ResponseEntity<T> post(T t, I id) {
  HttpStatus status = HttpStatus.BAD_REQUEST;

  if (!this.dao.exists(id)) {
   this.dao.save(t);
   status = HttpStatus.OK;
  } else {
   t = null;
  }

  return new ResponseEntity<T>(t, status);
 }

 public ResponseEntity<T> delete(I id) {
  HttpStatus status = HttpStatus.NOT_FOUND;

  if (this.dao.delete(id)) {
   status = HttpStatus.OK;
  }

  return new ResponseEntity<>(status);
 }

 interface patchFn<T> {
  T run(T t);
 }

 public ResponseEntity<T> patch(I id, patchFn<T> patch) {
  HttpStatus status = HttpStatus.NOT_FOUND;
  T t = null;

  if (this.dao.exists(id)) {
   t = this.dao.getExisting(id);

   t = patch.run(t);

   this.dao.save(t);
   status = HttpStatus.OK;
  }

  return new ResponseEntity<T>(t, status);
 }
}

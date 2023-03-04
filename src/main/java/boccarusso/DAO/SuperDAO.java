package boccarusso.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class SuperDAO<T, I> implements DAO<T, I> {
 @Autowired
 JpaRepository<T, I> repo;

 public long count() {
  return this.repo.count();
 }

 public Optional<T> get(I id) {
  return this.repo.findById(id);
 }

 public T getExisting(I id) {
  return this.repo.findById(id).get();
 }

 public Iterable<T> getAll() {
  return this.repo.findAll();
 }

 public Iterable<T> getAll(Pageable pageable) {
  return this.repo.findAll(pageable).getContent();
 }

 public T save(T t) {
  return this.repo.save(t);
 }

 public boolean exists(I id) {
  return this.repo.existsById(id);
 }

 public boolean delete(I id) {
  if (this.exists(id)) {
   this.repo.deleteById(id);
   return true;
  } else {
   return false;
  }
 }

 public void deleteExisting(I id) {
  this.repo.deleteById(id);
 }

}

package boccarusso.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class SuperDAO<T> implements DAO<T> {
 @Autowired
 JpaRepository<T, String> repo;

 public Optional<T> get(String id) {
  return this.repo.findById(id);
 }

 public T getExisting(String id) {
  return this.repo.findById(id).get();
 }

 public Iterable<T> getAll() {
  return this.repo.findAll();
 }

 public T save(T t) {
  return this.repo.save(t);
 }

 public boolean exists(String id) {
  return this.repo.existsById(id);
 }

 public boolean delete(String id) {
  if (this.exists(id)) {
   this.repo.deleteById(id);
   return true;
  } else {
   return false;
  }
 }

 public void deleteExisting(String id) {
  this.repo.deleteById(id);
 }

}

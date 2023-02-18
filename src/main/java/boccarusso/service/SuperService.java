package boccarusso.service;

import org.springframework.beans.factory.annotation.Autowired;

import boccarusso.DAO.SuperDAO;

public class SuperService<T> {
 @Autowired
 private SuperDAO<T> dao;

 public Iterable<T> getAll() {
  return this.dao.getAll();
 }
}

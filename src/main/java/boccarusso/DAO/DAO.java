package boccarusso.DAO;

import java.util.Collection;
import java.util.Optional;

public interface DAO<T> {
 Optional<T> get(String id);

 Collection<T> getAll();

 boolean save(T t);

 boolean update(T t);

 boolean delete(T t);
}

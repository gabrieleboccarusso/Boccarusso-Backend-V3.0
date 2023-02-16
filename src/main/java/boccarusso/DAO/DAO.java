package boccarusso.DAO;

import java.util.Optional;

public interface DAO<T> {
 Optional<T> get(String id);

 T getExisting(String id);

 Iterable<T> getAll();

 T post(T t);

 boolean put(T t);

 boolean delete(String id);

 boolean exists(String id);
}

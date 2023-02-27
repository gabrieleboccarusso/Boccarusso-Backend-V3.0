package boccarusso.DAO;

import java.util.Optional;

public interface DAO<T, I> {
 Optional<T> get(I id);

 T getExisting(I id);

 Iterable<T> getAll();

 T save(T t);

 boolean exists(I id);

 boolean delete(I id);

 void deleteExisting(I id);
}

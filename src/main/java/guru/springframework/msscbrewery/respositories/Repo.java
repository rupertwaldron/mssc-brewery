package guru.springframework.msscbrewery.respositories;

import java.util.List;
import java.util.UUID;

public interface Repo<T> {
    T findById(UUID uuid);

    void saveEntity(T entity);

    void updateEntity(T entity);

    List<T> listAll();

    void deleteById(UUID uuid);
}

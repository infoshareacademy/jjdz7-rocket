package teamrocket.dao;

import java.util.List;

public interface Dao<E> {

    void add(E e);

    void update(E e);

    E findById(int id);

    void deleteById(int id);

    List<E> findAll();

}
package teamrocket.dao;

import javax.ejb.Local;
import java.util.List;

@Local
public interface Dao<E> {

    void add(E e);

    void update(E e);

    E findById(int id);

    void deleteById(int id);

    List<E> findAll();

}
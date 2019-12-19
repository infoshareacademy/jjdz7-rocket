package teamrocket.dao;

import teamrocket.domain.Event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "events")
public class EventsDaoBean implements Dao {

    @PersistenceContext(unitName = "grajdolex-hibernate")
    protected EntityManager entityManager;

    @Override
    public void add(Object o) {
        entityManager.persist(o);
    }

    @Override
    public void update(Object o) {
        entityManager.merge(o);
    }

    @Override
    public Event findById(int id) {
        return entityManager.find(Event.class, id);
    }

    @Override
    public void deleteById(int id) {
        Event entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    @Override
    public List<Event> findAll() {
        Query query = entityManager.createNamedQuery("Event.findAll");
        return query.getResultList();
    }
}

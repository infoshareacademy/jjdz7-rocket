package teamrocket.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import teamrocket.domain.Event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "events")
public class EventsDaoBean implements Dao {
    private Logger logger = LogManager.getLogger(EventsDaoBean.class.getName());


    @PersistenceContext(unitName = "grajdolex-hibernate")
    protected EntityManager entityManager;

    @Override
    public void add(Object o) {
        logger.info("Try to add object to DB using entity manager.");
        entityManager.persist(o);
        logger.info("Object added to DB.");
    }

    @Override
    public void update(Object o) {
        logger.info("Try to update object in DB.");
        entityManager.merge(o);
        logger.info("Object in DB updated.");
    }

    @Override
    public Event findById(int id) {
        logger.info("Try to find object from DB by id.");
        Event event = entityManager.find(Event.class, id);
        logger.info("Object found.");
        return event;
    }

    @Override
    public void deleteById(int id) {
        logger.info("Try to find object from DB by id using prepared method.");

        Event entity = findById(id);
        logger.info("Check if object is not null.");

        if (entity != null) {
            logger.info("Try to delete object from DB.");

            entityManager.remove(entity);
            logger.info("Object deleted.");

        }
    }

    @Override
    public List<Event> findAll() {
        logger.info("Try to create query used for taking all games from DB.");

        Query query = entityManager.createNamedQuery("Event.findAll");

        logger.info("Try to return list of games.");
        return query.getResultList();
    }
}

package teamrocket.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import teamrocket.domain.Game;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "games")
public class GamesDaoBean implements Dao {

    private Logger logger = LogManager.getLogger(GamesDaoBean.class.getName());


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
    public Game findById(int id) {
        logger.info("Try to find object from DB by id.");
        Game game = entityManager.find(Game.class, id);
        logger.info("Object found.");
        return game;

    }

    @Override
    public void deleteById(int id) {
        logger.info("Try to find object from DB by id using prepared method.");
        Game entity = findById(id);
        logger.info("Check if object is not null.");
        if (entity != null) {
            logger.info("Try to delete object from DB.");
            entityManager.remove(entity);
            logger.info("Object deleted.");
        }
    }

    @Override
    public List<Game> findAll() {

        logger.info("Try to create query used for taking all games from DB.");
        Query query = entityManager.createNamedQuery("Game.findAll");
        logger.info("Try to return list of games.");
        return query.getResultList();
    }
}

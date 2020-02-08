package teamrocket.dao;

import teamrocket.domain.Game;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GamesDao implements GamesDaoInterface{

    @PersistenceContext
    protected EntityManager entityManager;

    public void add(Game o) {
//        logger.info("Try to add object to DB using entity manager.");
        entityManager.persist(o);
//        logger.info("Object added to DB.");
    }

}


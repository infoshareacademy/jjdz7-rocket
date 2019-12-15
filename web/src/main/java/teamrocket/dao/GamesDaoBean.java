package teamrocket.dao;


import teamrocket.domain.Game;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class GamesDaoBean implements Dao {

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
    public teamrocket.domain.Game findById(int id) {
        return entityManager.find(teamrocket.domain.Game.class, id);
    }

    @Override
    public void deleteById(int id) {
        teamrocket.domain.Game entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    @Override
    public List<Game> findAll() {

        Query query = entityManager.createNamedQuery("Game.findAll");
        return  query.getResultList();
    }
}

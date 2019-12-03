package teamrocket.dao;


import teamrocket.model.Game;
import teamrocket.util.Util;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class GamesDaoBean implements GamesDao {

    @PersistenceContext
    protected EntityManager entityManager;


    @Override
    public List<Game> getGamesList() throws IOException {

        List<String> stringList = new ArrayList<>();
        stringList = Util.readFileContent(Paths.get("/home/adrian/IdeaProjects/jjdz7-rocket/web/src/main/resources/gamesRepository.csv"));

        List<Game> gamesList = new ArrayList<>();
        for (int i = 0; i< stringList.size(); i++){
            gamesList.add(new Game(stringList.get(i)));

        }
        return gamesList;
    }

    @Override
    public void add(Object o) {
        entityManager.persist(o);
    }

    @Override
    public void update(Object o) {
        entityManager.merge(o);
    }

    @Override
    public Game findById(int id) {
        return entityManager.find(Game.class,id);
    }

    @Override
    public void deleteById(int id) {
        Game entity = findById(id);
        if (entity != null){
            entityManager.remove(entity);
        }
    }

    @Override
    public List findAll() {
        Query query = entityManager.createQuery("SELECT g FROM Games g");
        return query.getResultList();
    }
}

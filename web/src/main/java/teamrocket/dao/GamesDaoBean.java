package teamrocket.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class GamesDaoBean implements GamesDao {

    @PersistenceContext
    protected EntityManager entityManager;


//    @Override
//    public List<Game> getGamesList() throws IOException {
//
//        List<String> stringList = new ArrayList<>();
//        stringList = Util.readFileContent(Paths.get("/home/adrian/IdeaProjects/jjdz7-rocket/web/src/main/resources/gamesRepository.csv"));
//
//        List<Game> gamesList = new ArrayList<>();
//        for (int i = 0; i < stringList.size(); i++) {
//            gamesList.add(new Game(stringList.get(i)));
//
//        }
//        return gamesList;
//    }

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
    public List<teamrocket.domain.Game> findAll() {
        Query query = entityManager.createQuery("SELECT g FROM Games g");
        return (List<teamrocket.domain.Game>) query.getResultList();
    }
}

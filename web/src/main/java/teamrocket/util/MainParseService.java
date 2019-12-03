package teamrocket.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class MainParseService {

    public static void main(String[] args) throws IOException {

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("grajdolex-hibernate");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        GamesRepoParser gamesRepoParser = new GamesRepoParser(entityManager);
        gamesRepoParser.parseFileRepoFromAppModuleToDb();

        entityManager.getTransaction().commit();
    }

}

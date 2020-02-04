package teamrocket.services;

import teamrocket.util.GamesRepoParser;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.InputStream;

@ApplicationScoped
public class UploadFileService {

    public void readFileInput(InputStream fileContent){
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("grajdolex-hibernate");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        GamesRepoParser gamesRepoParser = new GamesRepoParser(entityManager);
        gamesRepoParser.parseFileRepoToDb(fileContent);

    }
}

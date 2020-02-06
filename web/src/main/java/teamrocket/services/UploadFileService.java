package teamrocket.services;

import teamrocket.util.GamesRepoParser;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.InputStream;

@ApplicationScoped
public class UploadFileService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void readFileInput(InputStream fileContent) {

        GamesRepoParser gamesRepoParser = new GamesRepoParser(entityManager);
        gamesRepoParser.parseFileRepoToDb(fileContent);

    }
}

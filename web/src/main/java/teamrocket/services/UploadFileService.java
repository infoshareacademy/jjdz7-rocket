package teamrocket.services;

import teamrocket.dao.Dao;
import teamrocket.domain.Game;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UploadFileService {

    @EJB(beanName = "games")
    Dao dao;


    public void readFileInput(InputStream fileContent) {
        List<Game> gamesEntityList = new ArrayList<>();
        gamesEntityList = (List<Game>) new InputStreamReader(fileContent);
        for (Game game: gamesEntityList){
            dao.add(game);
        }
    }
}

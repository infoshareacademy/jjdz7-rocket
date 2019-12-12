package teamrocket.services;

import teamrocket.dao.GamesDao;
import teamrocket.domain.Game;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.List;

@RequestScoped
public class GameService {

    @EJB
    GamesDao gamesDao;

    public List<Game> takeGameList () throws IOException {
        return gamesDao.findAll();
    }
}

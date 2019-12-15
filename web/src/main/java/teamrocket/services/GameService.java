package teamrocket.services;

import teamrocket.dao.Dao;
import teamrocket.domain.Game;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.List;

@RequestScoped
public class GameService {

    @EJB
    Dao dao;

    public List<Game> takeGameList () throws IOException {
        return dao.findAll();
    }
}

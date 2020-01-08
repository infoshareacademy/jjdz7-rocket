package teamrocket.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import teamrocket.dao.Dao;
import teamrocket.domain.Game;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.List;

@RequestScoped
public class GameService {

    private Logger logger = LogManager.getLogger(GameService.class.getName());

    @EJB(beanName = "games")
    Dao dao;

    public List<Game> takeGameList() throws IOException {
        logger.info("Try to take list of games from bean.");
        List list = dao.findAll();

        logger.error("Getting list of games from bean done.");
        return list;
    }
}

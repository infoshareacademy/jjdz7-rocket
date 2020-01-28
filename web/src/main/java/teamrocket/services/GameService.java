package teamrocket.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import teamrocket.dao.Dao;
import teamrocket.domain.Game;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RequestScoped
public class GameService {

    private Logger logger = LogManager.getLogger(GameService.class.getName());

    @EJB(beanName = "games")
    Dao dao;

    public List<Game> takeGameList() {
        logger.info("Try to take list of games from bean.");
        List list = dao.findAll();
        logger.error("Getting list of games from bean done.");

        sortListByExtraLook(list);

        return list;
    }

    private void sortListByExtraLook(List list) {
        logger.info("Try to sort list of games by extraLook.");
        Collections.sort(list, Comparator.comparing((Game game) -> !game.isExtraLook()));
        logger.info("Getting sorted list done.");
    }
}

package teamrocket.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import teamrocket.dao.Dao;
import teamrocket.domain.Event;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class EventService {

    private Logger logger = LogManager.getLogger(EventService.class.getName());

    @EJB(beanName = "events")
    Dao dao;

    public List<Event> takeEventList(){
        logger.info("Try to take list of events from bean.");
        List list = dao.findAll();
        logger.error("Getting list of events from bean done.");

        return list;
    }
}

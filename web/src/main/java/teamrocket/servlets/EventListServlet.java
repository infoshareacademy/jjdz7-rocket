package teamrocket.servlets;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import teamrocket.domain.Event;
import teamrocket.freemarker.TemplateProvider;
import teamrocket.services.EventService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/eventList")
public class EventListServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private EventService eventService;

    private Logger logger = LogManager.getLogger(EventListServlet.class.getName());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Try to get PrintWriter.");
        PrintWriter writer = resp.getWriter();
        logger.info("PrintWriter done.");


        Map<String, Object> model = new HashMap<>();

        logger.info("Try to get template from freemarker.");
        Template template = templateProvider.getTemplate(getServletContext(), "event-list.ftlh");
        logger.info("Getting template done.");

        logger.info("Try to make list of events from service.");
        List<Event> events = eventService.takeEventList();
        logger.info("Making list of events from service done.");
        logger.info("Try to put list of events into model map.");
        model.put("events", events);
        logger.info("List of events added into model map.");

        try {
            template.process(model, writer);
            logger.info("Template process done.");
        } catch (TemplateException e) {
            logger.error("Template process not done.");
            e.printStackTrace();
        }
    }
}

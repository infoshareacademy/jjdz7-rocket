package teamrocket.servlets;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import teamrocket.freemarker.TemplateProvider;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/admin")
@MultipartConfig
public class AdminServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    private Logger logger = LogManager.getLogger(AdminServlet.class.getName());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Try to get PrintWriter.");
        PrintWriter writer = resp.getWriter();
        logger.info("PrintWriter done.");

        Map<String, Object> model = new HashMap<>();

        logger.info("Try to get template from freemarker.");
        Template template = templateProvider.getTemplate(getServletContext(), "admin.ftlh");
        logger.info("Getting template done.");




        try {
            template.process(model, writer);
            logger.info("Template process done.");
        } catch (TemplateException e) {
            logger.error("Template process not done.");
            e.printStackTrace();
        }
    }
}

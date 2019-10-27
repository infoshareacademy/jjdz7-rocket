package teamrocket.servlets;

import freemarker.template.Template;
import teamrocket.freemarker.TemplateProvider;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addEvent")
public class AddEventServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AddEventServlet.class.getName());


    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        Template template = templateProvider
                .getTemplate(getServletContext(), "AddEvent.ftlh");
        Map<String, Object> model = new HashMap<> ();

        writer.println("<!DOCTYPE html><html><body>");
        writer.println("Here will be the form for adding new event!");
        writer.println("</body></html>");
    }
}

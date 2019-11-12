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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/map")
public class MapServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        Template template = templateProvider
                .getTemplate(getServletContext(), "Map.ftlh");
        Map<String, Object> model = new HashMap<> ();

        writer.println("<!DOCTYPE html><html><body>");
        writer.println("Here will be map with all places with opportunity to play!");
        writer.println("</body></html>");
    }
}

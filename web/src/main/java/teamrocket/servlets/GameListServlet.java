package teamrocket.servlets;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import teamrocket.domain.Game;
import teamrocket.freemarker.TemplateProvider;
import teamrocket.services.GameService;

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

@WebServlet("/gameList")
public class GameListServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    GameService gameService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        Map<String,Object> model = new HashMap<>();
        Template template = templateProvider.getTemplate(getServletContext(),"game-list.ftlh");

        List<Game> games = gameService.takeGameList();
        model.put("games",games);

        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}

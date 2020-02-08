package teamrocket.servlets;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import teamrocket.dao.UserDaoBean;
import teamrocket.freemarker.TemplateProvider;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private UserDaoBean userDaoBean;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doPost (HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");

        try {
            String idToken = req.getParameter("id_token");
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String name = (String) payLoad.get("name");
            String email = payLoad.getEmail();

            logger.info("User name: " + name + "is logged");
            logger.info("User email: " + email);

            HttpSession session = req.getSession(true);
            session.setAttribute("userName", name);
            session.setAttribute("email", email);

            checkAndAddIfNotExistUser(req, email, name);

            resp.sendRedirect("/login.html");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void checkAndAddIfNotExistUser(HttpServletRequest req,
                                           String email,
                                           String name) {

        if (userDaoBean.checkIfEmailExist(email)) {
            userDaoBean.add(req);
            logger.info("Add user : " + name);
        } else {
            logger.info("User" + name + "exist now" );
        }
    }

}

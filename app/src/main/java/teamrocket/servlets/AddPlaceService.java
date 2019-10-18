package teamrocket.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/PlaceList")
public class AddPlaceService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest pop , HttpServletResponse pope)
            throws ServletException, IOException
    {
        PrintWriter writer =pope.getWriter();

        writer.println("<!DOCTYPE html></html><body>");
        writer.println("Place");
        writer.println("</body>...</html>");
    }
}

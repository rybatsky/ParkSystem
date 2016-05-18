package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet index page.
 * @author Anastasiia Rybakova
 * @since 04.2016
 */

@WebServlet("/index")
public class Index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext();
        request.getSession(true).setAttribute("local", request.getParameter("local"));
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

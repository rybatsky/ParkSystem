package servlets.forester;

import dao.DaoForester;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Forester's log in servlet.
 * @author Anastasiia Rybakova
 * @since 04.2016
 */

@WebServlet("/forester/login")
public class LoginForester extends HttpServlet {

    private final static Logger logger = Logger.getLogger(servlets.forester.LoginForester.class);
    private DaoForester dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession(true);
        getServletContext();
        request.getRequestDispatcher("/forester/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        try {
            dao = new DaoForester();
        } catch (SQLException e) {
            logger.error(e);
        }
        if (dao.isForesterCorrect(request.getParameter("email"), request.getParameter("password"))) {
            request.getSession().setAttribute("email", request.getParameter("email"));
            response.sendRedirect("/forester/task/all");
        } else
            context.getRequestDispatcher("/errors/noSuchForester.jsp").forward(request, response);
    }
}

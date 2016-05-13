package servlets.forester;

import dao.DaoForester;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by rybatsky
 */

@WebServlet("/forester/login")
public class LoginForester extends HttpServlet {
    private DaoForester dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext();
        request.getSession(true).setAttribute("local", request.getParameter("local"));
        request.getRequestDispatcher("/forester/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        try {
            dao = new DaoForester();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (dao.isForesterCorrect(request.getParameter("email"), request.getParameter("password"))) {
            request.getSession().setAttribute("email", request.getParameter("email"));
            response.sendRedirect("/forester/tasks");
        } else
            context.getRequestDispatcher("/errors/noSuchForester.jsp").forward(request, response);
    }
}

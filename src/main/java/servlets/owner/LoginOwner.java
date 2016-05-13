package servlets.owner;

import dao.DaoOwner;

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

@WebServlet("/owner/login")
public class LoginOwner extends HttpServlet {
    private DaoOwner dao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        try {
            dao = new DaoOwner();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (dao.isOwnerCorrect(request.getParameter("email"), request.getParameter("password"))) {
            request.getSession().setAttribute("email", request.getParameter("email"));
            response.sendRedirect("/owner/task/all");
        } else
            context.getRequestDispatcher("/errors/noSuchOwner.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext();
        request.getSession(true).setAttribute("local", request.getParameter("local"));
        request.getRequestDispatcher("/owner/login.jsp").forward(request, response);
    }
}

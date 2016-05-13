package servlets.forester;

import dao.DaoForester;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/forester/signUp")
public class SignForester extends HttpServlet {

    private DaoForester dao;

    public SignForester() throws SQLException {
        super();
        dao = new DaoForester();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext();
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action != null) {
            doPost(request, response);
        } else {
            request.getSession(true).setAttribute("local", request.getParameter("local"));
            RequestDispatcher rd = request.getRequestDispatcher("/forester/signUp.jsp");
            rd.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String redirect = "/forester/login.jsp";
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        model.Forester forester = new model.Forester();
        forester.setFirstName(request.getParameter("first_name"));
        forester.setLastName(request.getParameter("last_name"));
        forester.setEmail(request.getParameter("email"));
        forester.setPassword(request.getParameter("password"));
        dao.addForester(forester);
        request.getRequestDispatcher(redirect).forward(request, response);
    }
}

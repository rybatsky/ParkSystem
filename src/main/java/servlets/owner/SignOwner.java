package servlets.owner;

import dao.DaoOwner;
import model.Owner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Owner's sign up servlet.
 * @author Anastasiia Rybakova
 * @since 04.2016
 */

@WebServlet("/owner/signUp")
public class SignOwner extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private DaoOwner dao;

    public SignOwner() throws SQLException {
        super();
        dao = new DaoOwner();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession(true);
        getServletContext();
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action != null) {
            doPost(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/owner/signUp.jsp");
            rd.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        Owner owner = new Owner();
        owner.setFirstName(request.getParameter("first_name"));
        owner.setLastName(request.getParameter("last_name"));
        owner.setParkName(request.getParameter("park_name"));
        owner.setEmail(request.getParameter("email"));
        owner.setPassword(request.getParameter("password"));
        dao.addOwner(owner);
        request.getRequestDispatcher("/owner/login.jsp").forward(request, response);
    }


}

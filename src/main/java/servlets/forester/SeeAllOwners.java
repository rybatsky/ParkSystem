package servlets.forester;

import dao.DaoForester;
import dao.DaoOwner;
import dao.DbConnection;
import model.Owner;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rybatsky
 */

@WebServlet("/forester/owners")
public class SeeAllOwners extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        ServletContext context = getServletContext();
        request.getSession(true);
        DbConnection.getConnection();
        response.setContentType("text/html");
        List<Owner> owners = new ArrayList<>();
        DaoOwner dao = null;
        try {
            dao = new DaoOwner();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (dao != null) {
                owners = dao.getAllOwners(owners);
        }
        request.setAttribute("owners", owners);
        try {
            context.getRequestDispatcher("/forester/owners.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package servlets.owner;

import dao.DaoForester;
import dao.DbConnection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rybatsky
 */

@WebServlet("/owner/foresters")
public class SeeAllForesters extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        ServletContext context = getServletContext();
        request.getSession(true);
        DbConnection.getConnection();
        response.setContentType("text/html");
        List<model.Forester> foresters = new ArrayList<>();
        DaoForester dao = null;
        try {
            dao = new DaoForester();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (dao != null) {
                foresters = dao.getAllForesters(foresters);
        }
        request.setAttribute("foresters", foresters);
        try {
            context.getRequestDispatcher("/owner/foresters.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package servlets.owner;

import dao.DaoForester;
import dao.DbConnection;
import org.apache.log4j.Logger;

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
 * Shows all foresters.
 * @author Anastasiia Rybakova
 * @since 04.2016
 */

@WebServlet("/owner/foresters")
public class SeeAllForesters extends HttpServlet {

    private final static Logger logger = Logger.getLogger(servlets.owner.SeeAllForesters.class);

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
            logger.error(e);
        }
        if (dao != null) {
                foresters = dao.getAllForesters(foresters);
        }
        request.setAttribute("foresters", foresters);
        try {
            context.getRequestDispatcher("/owner/foresters.jsp").forward(request, response);
        } catch (IOException e) {
            logger.error(e);
        }
    }

}

package servlets.owner.task;

import dao.DaoTask;
import model.Task;
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

import static dao.DbConnection.getConnection;

/**
 * Shows all tasks.
 * @author Anastasiia Rybakova
 * @since 04.2016
 */

@WebServlet("/owner/tasks")
public class SeeAllTasks extends HttpServlet {

    private final static Logger logger = Logger.getLogger(servlets.owner.task.SeeAllTasks.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        ServletContext context = getServletContext();
        getConnection();
        List<Task> tasks = new ArrayList<>();
        DaoTask dao = null;
        try {
            dao = new DaoTask();
        } catch (SQLException e) {
            logger.error(e);
        }
        request.getSession(true);
        request.setAttribute("allTasks", "All tasks");
        if (dao != null) {
            tasks = dao.getAllTasks(tasks);
        }
        request.setAttribute("tasks", tasks);
        try {
            context.getRequestDispatcher("/owner/task/all.jsp").forward(request, response);
        } catch (IOException e) {
            logger.error(e);
        }
    }
}

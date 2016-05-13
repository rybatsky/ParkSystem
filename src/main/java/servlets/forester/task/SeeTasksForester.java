package servlets.forester.task;

import dao.DaoForester;
import dao.DaoTask;
import model.Task;

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

import static dao.DbConnection.getConnection;

/**
 * Created by rybatsky
 */

@WebServlet("/forester/task/all")
public class SeeTasksForester extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        ServletContext context = getServletContext();
        getConnection();
        List<Task> tasks = new ArrayList<>();
        DaoTask dao = null;
        DaoForester daoForester = null;
        model.Forester forester = new model.Forester();
        try {
            dao = new DaoTask();
            daoForester = new DaoForester();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("email");
        if (daoForester != null) {
            forester = daoForester.getForesterByEmail(email);
        }
        int id = forester.getForesterId();
        if (dao != null) {
            tasks = dao.getTasksForForester(tasks, id);
        }
        if (tasks.isEmpty()) {
            request.setAttribute("allTasks", "There are no tasks for you");
        } else {
            request.setAttribute("allTasks", "Your tasks");
        }
        request.setAttribute("tasks", tasks);
        try {
            context.getRequestDispatcher("/forester/task/all.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

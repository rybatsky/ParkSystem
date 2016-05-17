package servlets.owner.task;

import dao.DaoOwner;
import dao.DaoTask;
import model.Owner;
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

@WebServlet("/owner/task/all")
public class SeeTasksOwner extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        ServletContext context = getServletContext();
        getConnection();
        HttpSession session = request.getSession(true);
        List<Task> tasks = new ArrayList<>();
        DaoTask dao = null;
        DaoOwner daoOwner = null;
        Owner owner = new Owner();
        try {
            dao = new DaoTask();
            daoOwner = new DaoOwner();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String email = (String) session.getAttribute("email");
        if (daoOwner != null) {
            owner = daoOwner.getOwnerByEmail(email);
        }
        int id = owner.getOwnerId();
        if (dao != null) {
            tasks = dao.getTasksForOwner(tasks, id);
        }
//        if (tasks.isEmpty()) {
//            request.setAttribute("allTasks", "There are no tasks for you");
//        } else {
//            request.setAttribute("allTasks", "Your tasks");
//        }
        request.setAttribute("tasks", tasks);
        try {
            context.getRequestDispatcher("/owner/task/all.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

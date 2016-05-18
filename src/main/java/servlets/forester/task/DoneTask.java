package servlets.forester.task;

import dao.DaoTask;
import model.Task;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet changes task's status: done/undone.
 * @author Anastasiia Rybakova
 * @since 04.2016
 */

@WebServlet("/forester/task/done")
public class DoneTask extends HttpServlet {

    private DaoTask dao;
    private Task task = new Task();
    private int taskId;

    public DoneTask() throws SQLException {
        super();
        dao = new DaoTask();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession(true);
        getServletContext();
        request.setCharacterEncoding("utf-8");
        taskId = Integer.parseInt(request.getParameter("taskId"));
        task = dao.getTaskById(taskId, task);
        request.setAttribute("task", task);
        String action = request.getParameter("action");
        if (action != null) {
            doPost(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/forester/task/done.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        dao.editIsDoneTask(taskId, Task.getDoneStatic(request.getParameter("done")));
        RequestDispatcher rd = request.getRequestDispatcher("/forester/task/doneDone.jsp");
        rd.forward(request, response);
    }
}
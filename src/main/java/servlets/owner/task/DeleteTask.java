package servlets.owner.task;

import dao.DaoTask;

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

@WebServlet("/owner/task/delete")
public class DeleteTask extends HttpServlet {
    private DaoTask dao;
    private int taskId;

    public DeleteTask() throws SQLException {
        super();
        dao = new DaoTask();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext();
        request.getSession(true);
        request.setCharacterEncoding("utf-8");
        taskId = Integer.parseInt(request.getParameter("taskId"));
        String action = request.getParameter("action");
        if (action != null)
            doPost(request, response);
        else {
            RequestDispatcher rd = request.getRequestDispatcher("/owner/task/delete.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        dao.delTask(taskId);
        RequestDispatcher rd = request.getRequestDispatcher("/owner/task/deleted.jsp");
        rd.forward(request, response);
    }
}






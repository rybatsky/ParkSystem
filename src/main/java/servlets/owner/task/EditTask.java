package servlets.owner.task;

import dao.DaoForester;
import dao.DaoOwner;
import dao.DaoTask;
import model.Forester;
import model.Owner;
import model.Task;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/owner/task/edit")
public class EditTask extends HttpServlet {

    private DaoTask dao;
    private DaoForester daoForester;
    private DaoOwner daoOwner;
    private Owner owner;
    private Task task = new Task();
    private int taskId;

    public EditTask() throws SQLException {
        super();
        dao = new DaoTask();
        daoOwner = new DaoOwner();
        daoForester = new DaoForester();
        owner = new Owner();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext();
        request.setCharacterEncoding("utf-8");
        List<Forester> foresters = new ArrayList<>();
        daoForester.getForestersNamesAndId(foresters);
        request.setAttribute("foresters", foresters);
        taskId = Integer.parseInt(request.getParameter("taskId"));
        request.setAttribute("taskId", taskId);
        int foresterId = dao.getIdForesterByTaskId(taskId);
        request.setAttribute("forester_id", foresterId);
        task = dao.getTaskById(taskId, task);
        request.setAttribute("task", task);
        owner = daoOwner.getOwnerByEmail((String) request.getSession(true).getAttribute("email"));
        request.setAttribute("owner", owner);
        String action = request.getParameter("action");
        if (action != null) {
            doPost(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/owner/task/edit.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        dao.setForesterId(Integer.parseInt(request.getParameter("NamesForester")));
        dao.editTask(taskId,
                dao.getForesterId(),
                request.getParameter("taskType"),
                request.getParameter("taskText"),
                Task.getDoneStatic(request.getParameter("done")),
                Task.getConfirmedStatic(request.getParameter("confirmed"))
        );
        RequestDispatcher rd = request.getRequestDispatcher("/owner/task/edited.jsp");
        rd.forward(request, response);
    }
}
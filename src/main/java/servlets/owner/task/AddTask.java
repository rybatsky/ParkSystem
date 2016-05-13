package servlets.owner.task;

import dao.DaoForester;
import dao.DaoOwner;
import dao.DaoTask;
import model.Owner;
import model.Task;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/task/add")
public class AddTask extends HttpServlet {

    private DaoTask dao;
    private DaoForester daoForester;
    private DaoOwner daoOwner;
    private Owner owner;

    public AddTask() throws SQLException {
        super();
        dao = new DaoTask();
        daoForester = new DaoForester();
        daoOwner = new DaoOwner();
        owner = new Owner();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext();
        request.setCharacterEncoding("utf-8");
        List<model.Forester> foresters = new ArrayList<>();
        daoForester.getForestersNamesAndId(foresters);
        request.setAttribute("foresters", foresters);
        owner = daoOwner
                .getOwnerByEmail((String) request.getSession(true).getAttribute("email"));
        request.setAttribute("owner", owner);
        String action = request.getParameter("action");
        if (action != null) {
            doPost(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/owner/task/add.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        Task task = new Task();
        task.setType(request.getParameter("type"));
        task.setComments(request.getParameter("comments"));
        dao.setOwnerId(owner.getOwnerId());
        dao.setForesterId(Integer.parseInt(request.getParameter("NamesForester")));
        dao.addTask(task);
        RequestDispatcher rd = request.getRequestDispatcher("/owner/task/all.jsp");
        rd.forward(request, response);
    }
}

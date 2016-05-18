package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Pages filter.
 * Checks, whether user is logged in.
 * @author Anastasiia Rybakova
 * @since 04.2016
 */

@WebFilter(filterName = "PagesFilter",
        urlPatterns = {"/owner/task/add",
                "/owner/task/all",
                "/owner/task/delete",
                "/owner/task/edit",
                "/forester/task/all",
                "/forester/task/done",
                "/forester/owners"})
public class PagesFilter implements Filter {

    private FilterConfig config;

    @Override
    public void init (FilterConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        ServletContext context = config.getServletContext();

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpServletRequest.getSession(true);

        if (session == null) {
            context.getRequestDispatcher("/error.jsp").forward(httpServletRequest, httpServletResponse);
        } else {
            String email = (String) session.getAttribute("email");
            session.getAttribute("local");
            if (email != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                httpServletRequest.getRequestDispatcher("/error.jsp").forward(httpServletRequest, httpServletResponse);
            }
        }
    }

    @Override
    public void destroy() {
        this.config = null;
    }
}

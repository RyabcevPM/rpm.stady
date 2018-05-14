package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet4 extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/faces/WelcomePage.jsp").forward(request, response);
    }
}

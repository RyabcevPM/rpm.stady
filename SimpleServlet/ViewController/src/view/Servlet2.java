package view;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet2 extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**Process the HTTP service request.
     */
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                                                                                         IOException {
        request.getRequestDispatcher("/faces/TestPage.jsp").forward(request, response);
    }
}

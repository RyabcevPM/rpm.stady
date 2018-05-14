package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet3 extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String var0 = "";
        try {
            var0 = request.getParameter("p_text");
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Servlet3</title></head>");
        out.println("<body>");
        out.println("<p>It's servlet with parameter. </p>");
        out.println("<p>p_text = \"" + var0 + "\" </p>");
        out.println("</body></html>");
        out.close();
    }
}

package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/temp")
public class TempServlet extends HttpServlet {

    // simple Cross Site Scripting defender
    String getSafeValue(String Value){
        return Value == null ? "" : Value.replaceAll("<", "&lt;").replaceAll(">","&gt;");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String one = getSafeValue(req.getParameter("one")).toLowerCase();
        if (one.equals("ok")) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else if (one.equals("bad")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,"blabla...bla!");
        } else if (one.equals("gonext")) {
            resp.sendRedirect("/hello2");
        } else if (one.equals("refresh")) {
            resp.sendRedirect("/hello2");
        } else resp.getWriter().write("It's temp Servlet");
    }
}

package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("init method from initServlet");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.getWriter().write("init jsp: ");
        Enumeration<String> initParameterNames = getServletConfig().getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            resp.getWriter().write(s + " = " + getServletConfig().getInitParameter(s) + "; ");
        }
        resp.getWriter().write("mail: " + getServletContext().getInitParameter("mail"));
    }
}

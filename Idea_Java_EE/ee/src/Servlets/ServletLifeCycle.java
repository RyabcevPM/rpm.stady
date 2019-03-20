package Servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/life")
public class ServletLifeCycle extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("ServletLifeCycle.service");
        super.service(req, res);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("ServletLifeCycle.init, thread:" + Thread.currentThread().getName());
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletLifeCycle.doGet");
        HttpSession session = req.getSession();
        session.setAttribute("one","two");
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String x = attributeNames.nextElement();
            resp.getWriter().write(x + " = " + session.getAttribute(x) + "; ");
        }
//        String s = "<html><header><title>This is my title</title><body>Step #3 LifeCycleR</body></html>";
//        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("doGet");
        super.destroy();
    }
}

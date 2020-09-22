package webapp1;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Hello World " + req.getMethod() + "\n");
        HttpSession session = req.getSession();
        String name = (String) session.getValue("name");
        if (name == null) {
            resp.getWriter().append("Hello somebody!");
            session.putValue("name", "my friend");
        } else {
            resp.getWriter().append("Hello " + name + "!");
        }

    }
}

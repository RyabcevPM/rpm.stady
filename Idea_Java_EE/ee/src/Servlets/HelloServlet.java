package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().write(
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>Title</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "one=" + req.getParameter("one") + "\n" +
                        "two=" + req.getParameter("two") + "\n" +
                        "<form action='act1' method='post'>\n" +
                        "    <input type=\"text\" name=\"one\">\n" +
                        "    <input type=\"text\" name=\"two\">\n" +
                        "    <input type=\"submit\" name=\"submit\">\n" +
                        "</form>\n" +
                        "</body>\n" +
                        "</html>"
);
        //super.doGet(req, resp);

    }
}

package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello2")
public class HelloServlet2 extends HttpServlet {

    // simple Cross Site Scripting defender
    String GetSafeValue(String Value){
        return Value == null ? "" : Value.replaceAll("<", "&lt;").replaceAll(">","&gt;");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String one = GetSafeValue(req.getParameter("one"));
        String two = GetSafeValue(req.getParameter("two"));

        resp.getWriter().write(
                        "<html><head>" +
                        "<title>Title</title>" +
                        "</head>" +
                        "<body>" +
                        "one=" + one + "\n" +
                        "two=" + req.getParameter("two") + "\n" +
                        "<form action='hello2' method='post'>" +
                        "<input type='text' name='one'/>" +
                        "<input type='text' name='two'/>" +
                        "<input type='submit' name='submit'/>" +
                        "</form>" +
                        "</body>" +
                        "</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}



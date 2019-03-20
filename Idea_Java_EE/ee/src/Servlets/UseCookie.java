package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie")
public class UseCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        resp.getWriter().write("It's UseCookieServlet.\n");
        for (Cookie c : cookies) {
            resp.getWriter().write(c.getName() + "=" +  c.getValue()+ "\n");
        }
        Cookie extra_cookie = new Cookie("testCookie","rpm");
        resp.addCookie(extra_cookie);
    }
}

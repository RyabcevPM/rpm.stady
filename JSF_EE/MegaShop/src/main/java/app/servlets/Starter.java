package app.servlets;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/start")
public class Starter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        String s = req.getParameter("lobby_type");
        resp.getWriter().write("I'm alive!\n");
        resp.getWriter().write("lobby_type = " + s);
//        resp.getWriter().write(req.getParameterNames().toString());

        while (req.getParameterNames().hasMoreElements()) {
            String name = req.getParameterNames().nextElement();
            resp.getWriter().write(name + " = " + req.getParameter(name));
        }
//        System.out.println(">>>>>>>>>>>>>>Starter.doGet(" + s);
//        if ("to_prime".equals(s)) {
//            requestDispatcher = req.getRequestDispatcher("/views/Loobby.xthml");
//        } else if ("to_jsp".equals(s)) {
//            requestDispatcher = req.getRequestDispatcher("/views/StartPage.jsp");
//        } else {
//            requestDispatcher = req.getRequestDispatcher("/views/Loobby2.xhthml");
//        }


//        requestDispatcher = req.getRequestDispatcher("/views/Lobby.xhtml");
//        requestDispatcher.forward(req, resp);
    }
}

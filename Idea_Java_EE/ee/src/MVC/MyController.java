package MVC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/mvc1")
public class MyController extends HttpServlet {
    MyModel myModel = new MyModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = null;
        try {
            student = myModel.getStudent();
            req.setAttribute("student", student); // scope: request
            student = myModel.getStudent();
            req.setAttribute("new_student", student); // scope: request
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //req.getSession().setAttribute("student", student); // scope: session
        //req.getServletContext().setAttribute("student", student); // scope: application
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        req.setAttribute("list",list);
        Map<String, String> map = new HashMap<>();
        map.put("one","first");
        map.put("two","second");
        req.setAttribute("map",map);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/First/MyView.jsp");        
        requestDispatcher.forward(req, resp);
    }
}

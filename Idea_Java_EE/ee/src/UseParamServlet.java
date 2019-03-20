import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/useParam")
public class UseParamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("UseParamServlet - doGet \n");
        String one = req.getParameter("one");
        resp.getWriter().write("one=" + one + '\n');
        Enumeration<String> paramName = req.getParameterNames();
        while (paramName.hasMoreElements()){
            String elemName = paramName.nextElement();
            resp.getWriter().write(elemName + " = " + req.getParameter(elemName) + '\n');
        }
        Map<String, String[]> paramMap = req.getParameterMap();


        resp.getWriter().write("It's UseParamServlet. \n" );
        resp.getWriter().write(req.getRequestURL() + "\n");
        resp.getWriter().write(req.getRequestURI() + "\n");
        resp.getWriter().write(req.getQueryString() + "\n");

    }
}

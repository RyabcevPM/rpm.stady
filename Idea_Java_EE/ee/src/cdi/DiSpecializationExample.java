package cdi;

import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/di8")
public class DiSpecializationExample extends HttpServlet {
    @Inject
    IMan man;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        man.printName();
        resp.getWriter().write("DiSpecializationExample: Hello!");
    }
}

interface  IMan{
    void printName();
}

class SuperMan implements IMan {
    @Override
    public void printName() {
        System.out.println("I'm Bill!");
    }
}

@Specializes
class Paco extends SuperMan {
    @Override
    public void printName() {
        System.out.println("I'm Paco, baby!");
    }
}


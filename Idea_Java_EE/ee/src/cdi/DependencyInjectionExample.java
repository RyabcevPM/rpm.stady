package cdi;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@WebServlet("/di1")
public class DependencyInjectionExample extends HttpServlet {

    @Inject
    SlyStudent student;

    @Inject
//    @StudentAnotation
    Person person;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        student.setName("Dilly");
        resp.getWriter().write("Hello " + student.getName() + "; ");
        resp.getWriter().write("Hello " + person.getName() + "; ");
    }
}

//@Qualifier
//@Retention(RUNTIME)
//@Target({FIELD, TYPE, METHOD})
//@interface StudentAnotation{}


interface Person {
    String getName();
}

@Alternative
class SlyStudent implements Person{
    private String name;

    public String getName() {
        if (name != null) {
            return name;
        } else {
            return "Student";
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Worker implements Person{
    private String name;

    public String getName() {
        if (name != null) {
            return name;
        } else {
            return "Worker";
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}


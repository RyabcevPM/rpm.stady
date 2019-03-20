package cdi;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
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
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("/di2")
public class DiProducesExmaple extends HttpServlet {
    @Inject
    String sx;

    @Inject
    @S2
    String sx2;

    @Inject
    int i;

    @Inject
    Car car1;

    @Inject
    Car car2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(sx2 + ": " + sx  + "  " + car1.getName() + " ; " + car2.getName() + "; i=" + Integer.toString(i));
    }
}

@Qualifier
@Retention(RUNTIME)
@Target({FIELD,TYPE,METHOD})
@interface S2{};

class Producer {
    @Produces
    String s = "Hello world!";
    @Produces
    @S2
    String s2 = "RyabcevPM";
    @Produces
    int age = 5;

    @Produces
    Car getCar(){
        return new Car("Lada #" + Integer.toString(age++));
    }

    public void clean(@Disposes Car car){
        car.doClean();
    }

}


class Car{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car(String name) {
        this.name = name;
    }

    public void doClean(){
        System.out.println("car clean ");
    }
}
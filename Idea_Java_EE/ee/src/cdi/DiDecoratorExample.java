package cdi;

import javafx.scene.Parent;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/di6")
public class DiDecoratorExample extends HttpServlet {

    @Inject
    IParent parent;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        parent.printName();
    }
}

interface IParent {
    public void printName();
}


class Child implements IParent {
    private String name;

    public String getName() {
        return "rpm";
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println("Child: My name is " + getName());
    }
}

@Decorator
class MyDecorator implements IParent {
    @Inject
    @Delegate
    IParent parent;

    @Override
    public void printName() {
        System.out.println("MyDecorator: before print");
        parent.printName();
        System.out.println("MyDecorator: after print");
    }
}
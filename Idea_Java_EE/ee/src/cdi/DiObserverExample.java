package cdi;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("/di7")
public class DiObserverExample extends HttpServlet {
    @Inject
    BookService bookService;

    @Inject
    Subscriber subscriber;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------------------");
        bookService.addBook(new Book("one"));
        System.out.println("-------------------");
        Book two = new Book("two");
        bookService.addBook(two);
        System.out.println("-------------------");
        bookService.addBook(new Book("three"));
        System.out.println("-------------------");
        bookService.delBook(two);
        System.out.println("-------------------");
        resp.getWriter().print("It's DiObserverExample: " + subscriber.list.size() + "; ");
        for (Book book: subscriber.list) {
            resp.getWriter().print(book.getName() + "; ");

        }
    }
}

@Qualifier
@Target({METHOD, FIELD, PARAMETER, TYPE})
@Retention(RUNTIME)
@interface Add{}

@Qualifier
@Target({METHOD, FIELD, PARAMETER, TYPE})
@Retention(RUNTIME)
@interface Del{}



class Book {
    String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

@Singleton
class BookService{
    @Inject
    @Add
    Event<Book> addEvent;

    @Inject
    @Del
    Event<Book> delEvent;

    public void addBook(Book book) {
        System.out.println("BookService: " + book.getName() + " book was added");
        addEvent.fire(book);
    }

    @Del
    public void delBook(Book book) {
        System.out.println("BookService: " + book.getName() + " book was removed");
        delEvent.fire(book);
    }
}

@Singleton
class Subscriber {
  List<Book> list = new ArrayList<>();


    public void add(@Observes @Add Book book){
        System.out.println("Subscriber: " + book.getName() + " added to list");
        list.add(book);
    }

    public void delete(@Observes @Del Book book){
        System.out.println("Subscriber: " + book.getName() + " deleted to list");
        list.remove(book);
    }

}
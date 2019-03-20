package Servlets;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

@WebServlet("/SingleThread")
public class SingleThreadServlet extends HttpServlet {
    static int i = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (int j = 0; j < 1_000_000; j++) {
            i++;
        }
        System.out.println(i);
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("213");
    }
//    public static void main(String[] args) {
//        for (int j = 0; j < 2; j++) {
//            System.out.println("j");
////            new Thread() {
////                @Override
////                public void run() {
////                    try {
////                        URLConnection uc = new URL("http://localhost:8080/hello").openConnection();
////                        uc.getInputStream();
////                    } catch (IOException e) {
////                        e.printStackTrace();
////                    }
////                }
////            }.start();
//        }
//    }


}

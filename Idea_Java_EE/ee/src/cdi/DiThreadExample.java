package cdi;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedExecutors;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

@WebServlet("/di9")
public class DiThreadExample extends HttpServlet {
    @Resource
    ManagedExecutorService executorService;
    @Resource
    ManagedScheduledExecutorService scheduledExecutorService;
    @Resource
    ManagedThreadFactory managedThreadFactory;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        executorService.submit(new MyRunnuble());
        executorService.submit(new MyRunnuble());
        try {
            System.out.println(executorService.submit(new MyCallable<>()).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        resp.getWriter().write("DiThreadExample: Hello!");
    }

    static class MyRunnuble implements Runnable{
        int i;
        static int myNum;

        @Override
        public void run() {
            int currentNum = ++myNum;
            System.out.println("MyRunnuble is started");
            for (int j = 0; j < 100000000; j++) {
                i = Math.floorMod(j, 10000000);
                if (i==0) {
                    System.out.println(currentNum);
                }
            }
        }
    }

    static class MyCallable<T> implements Callable<String>{
        int i;
        @Override
        public String call() throws Exception {
            System.out.println("MyCallable is started");
            for (int j = 0; j < 100000000; j++) {
                i = Math.floorMod(j, 40000000);
                if (i==0) {
                    return "MyCallable complete";
                }
            }
            return null;
        }
    }
}

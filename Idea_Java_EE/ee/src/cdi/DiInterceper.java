package cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/di4")
public class DiInterceper extends HttpServlet {
    @Inject
    SecondLifeCycleBean lifeCycleBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------------------");
        lifeCycleBean.DoJob();
        System.out.println("-----------------------");
        lifeCycleBean.DoJob2();
        System.out.println("-----------------------");
        lifeCycleBean.DoJob3();
        System.out.println("-----------------------");
        resp.getWriter().write("It is DiInterceper.");
    }
}

@RequestScoped
class LifeCycleBean {
    public LifeCycleBean() {
        System.out.println("construct LifeCycleBean");
    }

    @AroundInvoke
    private Object aroundInvoke (InvocationContext context) throws Exception {
        System.out.println("aroundInvoke before method " + context.getMethod().getName());
        return context.proceed();
    }

    public void DoJob(){
        System.out.println("do job");
    }
    public void DoJob2(){
        System.out.println("do job2");
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("LifeCycleBean my preDestroy method");
    }

}

class InterceptorOne {
    @AroundConstruct
    private void aroundConstruct(InvocationContext context) throws Exception{
        System.out.println("One: before construct");
        context.proceed();
    }

    @PostConstruct
    private void postConstruct(InvocationContext context) throws Exception{
        System.out.println("One: post construct");
        context.proceed();
//        return context.proceed();
    }

    @AroundInvoke
    private Object aroundInvoke (InvocationContext context) throws Exception {
        System.out.println("One: aroundInvoke before method " + context.getMethod().getName());
        return context.proceed();
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("One: preDestroy method");
    }

}

class InterceptorTwo {
    @AroundInvoke
    private Object aroundInvoke (InvocationContext context) throws Exception {
        System.out.println("Two: aroundInvoke before method " + context.getMethod().getName());
        return context.proceed();
    }

}

class InterceptorThree {
    @AroundInvoke
    private Object aroundInvoke (InvocationContext context) throws Exception {
        System.out.println("Three: aroundInvoke before method " + context.getMethod().getName());
        return context.proceed();
    }

}


@RequestScoped
@Interceptors({InterceptorOne.class, InterceptorTwo.class})
class SecondLifeCycleBean {
    public SecondLifeCycleBean() {
        System.out.println("SecondLifeCycleBean: construct LifeCycleBean");
    }

    @Interceptors(InterceptorThree.class)
    public void DoJob(){
        System.out.println("SecondLifeCycleBean: do job #1");
    }

    @ExcludeClassInterceptors
    public void DoJob2(){
        System.out.println("SecondLifeCycleBean: do job #2");
    }

    public void DoJob3(){
        System.out.println("SecondLifeCycleBean: do job #3");
    }

}

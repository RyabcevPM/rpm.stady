package cdi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InterceptorBinding;
import javax.interceptor.InvocationContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("/di5")
public class DiInterceperBinding extends HttpServlet {
    @Inject
    MyService myService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--------------------");
        myService.runService();
        System.out.println("--------------------");
        myService.runService2();
        System.out.println("--------------------");
        myService.runService3();
        System.out.println("--------------------");
        resp.getWriter().write("It is interceper's binding.");
    }
}

@InterceptorBinding
@Target({METHOD, TYPE})
@Retention(RUNTIME)
@interface OneBind {}

@InterceptorBinding
@Target({METHOD, TYPE})
@Retention(RUNTIME)
@interface TwoBind {}


@InterceptorBinding
@Target({METHOD, TYPE})
@Retention(RUNTIME)
@interface ThreeBind {}



@OneBind
@Interceptor
class InterceptorOneBind{
    @AroundInvoke
    private Object aroundInvoke (InvocationContext context) throws Exception {
        System.out.println("Bind interceptor one: aroundInvoke before method " + context.getMethod().getName());
        return context.proceed();
    }
}


@OneBind
@Interceptor
class InterceptorExtraOneBind{
    @AroundInvoke
    private Object aroundInvoke (InvocationContext context) throws Exception {
        System.out.println("Bind interceptor one2: aroundInvoke before method " + context.getMethod().getName());
        return context.proceed();
    }
}



@TwoBind
@Interceptor
class InterceptorTwoBind{
    @AroundInvoke
    private Object aroundInvoke (InvocationContext context) throws Exception {
        System.out.println("Bind interceptor two: aroundInvoke before method " + context.getMethod().getName());
        return context.proceed();
    }
}


@ThreeBind
@Interceptor
class InterceptorThreeBind{
    @AroundInvoke
    private Object aroundInvoke (InvocationContext context) throws Exception {
        System.out.println("Bind interceptor three: aroundInvoke before method " + context.getMethod().getName());
        return context.proceed();
    }
}



@RequestScoped
@OneBind
class MyService {
    void runService(){
        System.out.println("MyService: runService #1 method");
    }

    @TwoBind
    void runService2(){
        System.out.println("MyService: runService #2 method");
    }

    @TwoBind
    @ThreeBind
    void runService3(){
        System.out.println("MyService.runService #3 method");
    }
}



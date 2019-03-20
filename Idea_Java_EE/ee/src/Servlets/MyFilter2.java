package Servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/life")
public class MyFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter2.init");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter2.destroy");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter2.destroy");
        servletResponse.getWriter().write("<html><head><title>Filter2</title></head><body><br>Header from filter2<br><br>" );
        filterChain.doFilter(servletRequest, servletResponse);
        servletResponse.getWriter().write("</body></html>");

    }
}

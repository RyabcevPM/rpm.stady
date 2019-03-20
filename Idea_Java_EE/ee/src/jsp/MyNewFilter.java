package jsp;


import javax.servlet.*;
import java.io.IOException;

public class MyNewFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getInitParameter("name"));
        System.out.println("init filter");
    }

    @Override
    public void destroy() {
        System.out.println("destroy filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.getWriter().write("before");
        if (true) {
            filterChain.doFilter(servletRequest, servletResponse);
        };
        servletResponse.getWriter().write("after");
    }
}

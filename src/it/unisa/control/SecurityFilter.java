package it.unisa.control;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String uri = httpRequest.getRequestURI();

        if (uri.contains("META-INF/context.xml") || uri.contains("WEB-INF/web.xml")) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/error.html");
        } else {
            chain.doFilter(request, response);
        }
    }

}
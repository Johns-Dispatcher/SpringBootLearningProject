package pers.johns.springboot.servlet.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

/**
 * ClassName    : LogFilter
 * Description  : Filter
 * CreateTime   : 2024/6/7 10:12
 *
 * @author : JohnS
 * @version : 1.0
 */

@WebFilter("/*")
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        System.out.println("== LogFilter ==");
        System.out.println("Request Path = " + httpServletRequest.getRequestURI());

        filterChain.doFilter(request, response);
    }
}

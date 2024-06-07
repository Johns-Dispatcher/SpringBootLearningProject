package pers.johns.springboot.servlet.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName    : LoginServlet
 * Description  :
 * CreateTime   : 2024/6/7 9:55
 *
 * @author : JohnS
 * @version : 1.0
 */

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<h3>LoginServlet in SpringBoot</h3>");
        out.flush();
        out.close();
    }
}

package pers.johns.springboot.servlet.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName    : HelloServlet
 * Description  : Servlet
 * CreateTime   : 2024/6/7 9:27
 *
 * @author : JohnS
 * @version : 1.0
 */

// 相当于<servlet>标签的配置
@WebServlet(
        urlPatterns = "/helloServlet",
        name = "HelloServlet"
)
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<h3>HelloServlet in SpringBoot</h3>");
        out.flush();
        out.close();
    }
}

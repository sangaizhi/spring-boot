package org.sangaizhi.springboot.ch6.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sangaizhi
 * @date 2017/6/9
 */
@WebServlet(urlPatterns = "/myAnnoServlet/*", description = "这是一个自定义的Servlet")  // 表示当前 bean 是一个 Servlet
public class MyAnnoServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求自定义的 MyAnnoServlet");
        req.setAttribute("message","执行自定义 MyAnnoServlet");
        req.getRequestDispatcher("/WEB-INF/view/myAnnoServlet.jsp").forward(req, resp);
    }
}

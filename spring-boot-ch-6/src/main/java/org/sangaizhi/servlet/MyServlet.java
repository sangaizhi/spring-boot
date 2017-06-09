package org.sangaizhi.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义 Servlet,采用代码的是注册该 Servlet
 * @author sangaizhi
 * @date 2017/6/9
 */
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求自定义的 MyServlet");
        req.setAttribute("message","执行自定义 MyServlet");
        req.getRequestDispatcher("/views/myServlet.jsp").forward(req, resp);
    }

}

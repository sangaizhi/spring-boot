package org.sangaizhi.springboot.ch6.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author sangaizhi
 * @date 2017/6/9
 */
@WebFilter(filterName = "MyAnnoFilter", urlPatterns = "/*")
public class MyAnnoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化 MyAnnoFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyAnnoFilter 正在执行过滤任务");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("销毁 MyAnnoFilter");
    }
}

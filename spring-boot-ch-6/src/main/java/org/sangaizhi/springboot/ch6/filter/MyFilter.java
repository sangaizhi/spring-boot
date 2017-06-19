package org.sangaizhi.springboot.ch6.filter;

import java.io.IOException;

import javax.servlet.*;

/**
 * 自定义 Filter
 * @author sangaizhi
 * @date 2017/6/9
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化 MyFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter 正在执行过滤任务");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("销毁 MyFilter");
    }
}

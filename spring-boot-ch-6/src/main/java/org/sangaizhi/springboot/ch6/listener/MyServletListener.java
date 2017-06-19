package org.sangaizhi.springboot.ch6.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 自定义监听器,采用代码的方式注册该 Listener
 * @author sangaizhi
 * @date 2017/6/9
 */
public class MyServletListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("初始化监听器");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("销毁监听器");
    }
}

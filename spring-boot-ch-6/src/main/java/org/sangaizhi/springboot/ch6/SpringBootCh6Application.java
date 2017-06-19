package org.sangaizhi.springboot.ch6;

import org.sangaizhi.springboot.ch6.filter.MyFilter;
import org.sangaizhi.springboot.ch6.listener.MyServletListener;
import org.sangaizhi.springboot.ch6.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class SpringBootCh6Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCh6Application.class, args);
	}

	/**
	 * 自定义Session Listener
	 * @return
	 */
	@Bean
	public ServletListenerRegistrationBean myListener(){
		ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean();
		registrationBean.setListener(new MyServletListener());
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean myFilter(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new MyFilter());
		registrationBean.addUrlPatterns("/*");
		registrationBean.setName("myFilter");
		registrationBean.setOrder(1);
		return  registrationBean;
	}

	@Bean
	public ServletRegistrationBean myServlet(){
		ServletRegistrationBean registrationBean = new ServletRegistrationBean();
		registrationBean.setServlet(new MyServlet());
		registrationBean.addUrlMappings("/myServlet/*");
		return registrationBean;
	}
}

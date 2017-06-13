package org.sangaizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class SpringBootCh7Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCh7Application.class, args);
	}
	@RequestMapping("/")
	@ResponseBody
	public Object index(){
		return "Hello Spring boot ch 7";
	}

	@RequestMapping("/tomcat")
	public String tomcat(){
		return "tomcat";
	}

	@RequestMapping("/jetty")
	public String jetty(){
		int i = 100 / 0;
		return "jetty";
	}

//	@Component
//	public static class CustomerServletContainer implements EmbeddedServletContainerCustomizer{
//		@Override
//		public void customize(ConfigurableEmbeddedServletContainer container) {
//			container.setContextPath("/cusServlet2");
//			container.setPort(9999);
//		}
//	}

//	/**
//	 * 配置 Tomcat Servlet 容器
//	 * @return
//	 */
//	@Bean
//	public EmbeddedServletContainerFactory tomcatServletFactory(){
//		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
//		factory.setPort(8080);
//		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
//		factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500.html"));
//		factory.setSessionTimeout(5000);
//		return factory;
//	}

	/**
	 * 配置 Jetty Servlet 容器
	 * @return
	 */
//	@Bean
//	public EmbeddedServletContainerFactory jettyServletContainer(){
//		JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory();
//		factory.setPort(10002);
//  	factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
//		factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500.html"));
//		return factory;
//	}

}

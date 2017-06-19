package org.sangaizhi.jpa;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class SpringBootCh8Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCh8Application.class, args);
	}

	/**
	 * 配置 Tomcat Servlet 容器
	 * @return
	 */
	@Bean
	public EmbeddedServletContainerFactory tomcatServletFactory(){
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory(){
			// 在 Tomcat 处理请求之前，先处理 Tomcat 的上下文
			protected void postProcessContext(Context context) {

				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				// 安全集合
				SecurityCollection collection = new SecurityCollection();
				// 添加需安全处理的路径
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};
		// 给 Tomcat 设置一个附加的 Connector
		factory.addAdditionalTomcatConnectors(httpConnector());
		factory.setPort(8080);
		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
		factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500.html"));
		factory.setSessionTimeout(5000);
		return factory;
	}

	@Bean
	public Connector httpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("https");
		connector.setPort(8081);
		connector.setSecure(false);
		connector.setRedirectPort(8080);
		return connector;
	}


}

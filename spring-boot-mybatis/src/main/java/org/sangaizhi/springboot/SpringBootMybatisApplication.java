package org.sangaizhi.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "org.sangaizhi.springboot", exclude = {DataSourceAutoConfiguration.class})
public class SpringBootMybatisApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootMybatisApplication.class, args);
	}
}

package org.sangaizhi;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 的入口类，
 */

@SpringBootApplication
public class SpringBootCh2Application {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SpringBootCh2Application.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		SpringApplication.run(SpringBootCh2Application.class, args);
	}
}

package org.sangaizhi.springboot.ch3;

import org.sangaizhi.springboot.ch3.model.TestProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableConfigurationProperties
public class SpringBootCh3Application {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootCh3Application.class);

	@Value("${book.name}")
	private String name;
	@Value("${book.author}")
	private String author;

	@Autowired
	private TestProperties properties;

	@RequestMapping("/")
	public String index(){
		return "Hello,Book Name is:" + name + ", the author is:" + author;
	}

	@RequestMapping("/config")
	public String index2(){
		logger.info("test spring boot log");
		return properties.toString();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCh3Application.class, args);
	}
}

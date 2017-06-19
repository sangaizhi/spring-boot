package org.sangaizhi.springboot.ch4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootCh4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCh4Application.class, args);
	}

	@Autowired
	private MessageService messageService;
	@RequestMapping("/")
	public String index(){
		return messageService.sayHello();
	}

}

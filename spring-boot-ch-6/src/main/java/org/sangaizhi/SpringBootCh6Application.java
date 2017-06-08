package org.sangaizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

@SpringBootApplication
public class SpringBootCh6Application {

//	@Bean
//	public HttpMessageConverters myMessageConverters(){
//		HttpMessageConverter<?> myConverter1 = new MyMessageConverter1();
//		HttpMessageConverter<?> myConverter2 = new MyMessageConverter2();
//		return new HttpMessageConverters(myConverter1, myConverter2);
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCh6Application.class, args);
	}
}

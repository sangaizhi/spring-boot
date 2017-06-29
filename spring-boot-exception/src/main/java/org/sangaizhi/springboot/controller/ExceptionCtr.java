package org.sangaizhi.springboot.controller;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author sangaizhi
 * @date 2017/6/28
 */
@RestController
@RequestMapping("/exception")
public class ExceptionCtr {

	@RequestMapping("/missingServletRequestParameterException")
	public String missingServletRequestParameterException(@RequestParam(value = "id", required = true) Long id) {
		return "ok";
	}

	@RequestMapping("/httpMessageNotReadableException")
	public String httpMessageNotReadableException( Date date) {
		throw new HttpMessageNotReadableException("");
	}

	@RequestMapping("/methodArgumentNotValidException")
	public String methodArgumentNotValidException(@Valid Long id) {
		return "ok";
	}

	@RequestMapping("/bindException")
	public String bindException(Long id) {
		return "ok";
	}

}

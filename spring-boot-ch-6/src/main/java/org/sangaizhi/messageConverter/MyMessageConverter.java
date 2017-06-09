package org.sangaizhi.messageConverter;

import java.io.IOException;
import java.nio.charset.Charset;

import org.sangaizhi.model.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;


public class MyMessageConverter extends AbstractHttpMessageConverter<User> {//1

	public MyMessageConverter() {
		super(new MediaType("application", "text-html", Charset.forName("UTF-8")));//2
	}

	@Override
	protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage)
		throws IOException, HttpMessageNotReadableException {
		String temp = StreamUtils.copyToString(inputMessage.getBody(),

			Charset.forName("UTF-8"));
		String[] tempArr = temp.split("-");
		return new User(new Long(tempArr[0]), tempArr[1]);
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	protected void writeInternal(User obj, HttpOutputMessage outputMessage)
		throws IOException, HttpMessageNotWritableException {
		String out = "hello:" + obj.getId() + "-" + obj.getName();
		outputMessage.getBody().write(out.getBytes());
	}

}

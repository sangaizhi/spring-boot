package org.sangaizhi.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sangaizhi
 * @date 2017/6/9
 */
public class MyInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
        System.out.println("开始处理请求");
        long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, //3
		HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		request.removeAttribute("startTime");
		long endTime = System.currentTimeMillis();
		System.out.println("本次请求处理时间为:" + (endTime - startTime) + "ms");
		request.setAttribute("handlingTime", endTime - startTime);
	}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("处理请求结束");
    }
}

package org.sangazihi.webSocket.point2point;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author sangaizhi
 * @date 2017/6/14
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 配置 Spring Security 拦截的路径
     *  1: 配置对 "/" 和 "/login" 路径不拦截
     *  2: 设置 Spring Security 的登录页面访问的路径为 /login
     *  3: 登录成功后转向 /chat 路径
     * @param http
     * @throws Exception
     */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/login").permitAll().anyRequest().authenticated().and().formLogin()
			.loginPage("/login").defaultSuccessUrl("/chat").permitAll().and().logout().permitAll();
	}

    /**
     * 配置认证管理器
	 * 此处在内存中默认设置了两个用户，角色是 USER
     * @param auth
     * @throws Exception
     */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("sangaizhi").password("sangaizhi").roles("USER").and()
			.withUser("sangzongjie").password("sangzongjie").roles("USER");
	}

	/**
	 * 配置静态资源不拦截
	 * @param web
	 * @throws Exception
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/static/**");
	}
}

package org.sangaizhi.springboot.security;

import org.sangaizhi.springboot.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 配置 Spring Security
 * @author sangaizhi
 * @date 2017/7/12
 */
@Configuration
@EnableWebSecurity  // 开启 Spring Security 功能
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    /**
     * 用户认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(customUserDetailService);
    }

    /**
     * 请求授权
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/","/css/**","/image/*","/js/**","/loginPage").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/loginPage").failureUrl("/loginPage?error").loginProcessingUrl("/login").successForwardUrl("/home").permitAll()
                .and().logout().permitAll();
    }
}

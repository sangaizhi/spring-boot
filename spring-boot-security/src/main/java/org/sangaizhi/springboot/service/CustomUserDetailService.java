package org.sangaizhi.springboot.service;

import org.sangaizhi.springboot.model.User;
import org.sangaizhi.springboot.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义实现 UserDetailService,
 * 从数据库中查询用户数据，封装为Spring Security 的 User 返回
 *
 * @author sangaizhi
 * @date 2017/7/12
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findByUsername(s);
        if(null == user){
            return null;
        }
        List<UserRole> userRoles = userRoleService.getByUserId(user.getId());
        List<GrantedAuthority> authorityList = new ArrayList();
        for(UserRole userRole : userRoles){
            if(null != userRole.getRole()){
                authorityList.add(new SimpleGrantedAuthority("ROLE_"+userRole.getRole().getName()));
            }
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorityList);
    }
}

package org.sangaizhi.springboot.controller;

import org.sangaizhi.springboot.dao.UserRepository;
import org.sangaizhi.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sangaizhi
 * @date 2017/6/29
 */
@RestController
@RequestMapping("/mongo")
public class MongoController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/save")
    @ResponseBody
    public User save(){
        User user = new User();
        user.setName("eric-sang");
        user.setId(1L);
        user.setAge(19);
        user.setAddress("深圳");
        userRepository.save(user);
        return user;
    }

    @RequestMapping("/find")
    @ResponseBody
    public User findByName(String name){
        return userRepository.findByName(name);
    }


}

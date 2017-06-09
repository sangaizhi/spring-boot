package org.sangaizhi.controller;

import org.sangaizhi.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sangaizhi
 * @date 2017/6/9
 */
@Controller
public class MyController {

    @RequestMapping("/{page}")
    public String index(@PathVariable String page){
        return  page;
    }

}

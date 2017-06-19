package org.sangaizhi.springboot.ch3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sangaizhi
 * @date 2017/6/7
 */
@RestController  //
public class PropertyController {

    @RequestMapping("/property")
    public String index() {
        return "Hello World";
    }

}

package org.sangaizhi.springboot.controller;

import org.sangaizhi.springboot.model.Person;
import org.sangaizhi.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sangaizhi
 * @date 2017/6/22
 */

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/rollback")
    public Person rollback(Person person){
        return personService.saveWithRollBack(person);
    }
    @RequestMapping("/noRollback")
    public Person noRollback(Person person){
        return personService.saveWithoutRollBack(person);
    }
}

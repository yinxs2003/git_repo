package com.mvc.controller;

import com.mvc.entity.Person;
import com.mvc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/person/findAll")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @RequestMapping(value = "/person/addPerson", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
    public String addPerson(@RequestParam Person person) {
        int count = personService.addService(person);
        if(count>0){

        }
        return "";
    }
}

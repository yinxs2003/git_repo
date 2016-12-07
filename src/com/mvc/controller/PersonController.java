package com.mvc.controller;

import com.mvc.entity.Person;
import com.mvc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("/findAllPerson")
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

    @RequestMapping(value="/findPersonByCondition")
    public void findPersonByCondition(@RequestParam String personName){
        List<Person> personList = personService.findPersonByCondition(personName);
        httpServletRequest.setAttribute("personList",personList);
    }
}

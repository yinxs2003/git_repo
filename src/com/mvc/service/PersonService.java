package com.mvc.service;

import com.mvc.entity.Person;
import com.mvc.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonMapper personMapper;

    public List<Person> findAll(){
        return personMapper.findAll();
    }

    public int addService(Person person) {
        return personMapper.addPerson(person);
    }
}

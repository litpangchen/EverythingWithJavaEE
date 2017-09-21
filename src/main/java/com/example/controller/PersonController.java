package com.example.controller;

import com.example.pojo.Person;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    @Qualifier(value = "personService")
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    public Person getPersonById(@PathVariable("id") int id) {
        Person person = this.personService.getPersonById(id);
        return person;
        //return new ResponseEntity<>(person, HttpStatus.OK);
    }
}

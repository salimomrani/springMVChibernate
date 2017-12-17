package com.luv2code.controller;

import com.luv2code.entity.Person;
import com.luv2code.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by salim on 15/10/17 2017 project springMVChibernate.
 */
@Controller
public class PersonController {


    private  PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("persons")
    public ModelAndView listPersons(Model model){

        List<Person> personList = personService.listPerson();

        model.addAttribute("person",new Person());
        model.addAttribute("listPersons",personList);

        return new ModelAndView("person");
    }

    @PostMapping("person/add")
    public ModelAndView addPerson(@ModelAttribute("person") Person person){

        if (person.getId() ==0){
            personService.addPerson(person);
        }else {
            personService.updatePerson(person);
        }

        return new ModelAndView("redirect:/persons");
    }

    @GetMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){

        this.personService.removePerson(id);
        return "redirect:/persons";
    }

    @GetMapping(name ="edit" ,path = "/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personService.getPerson(id));
        model.addAttribute("listPersons", personService.listPerson());
        return "person";
    }
}

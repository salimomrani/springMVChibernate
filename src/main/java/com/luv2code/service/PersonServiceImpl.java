package com.luv2code.service;

import com.luv2code.dao.PersonDAO;
import com.luv2code.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by salim on 15/10/17 2017 project springMVChibernate.
 */

@Service
public class PersonServiceImpl implements PersonService {


    private final PersonDAO personDAO;

    @Autowired
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @Transactional
    public void addPerson(Person person) {

        personDAO.addPerson(person);
    }

    @Transactional
    public void updatePerson(Person person) {
        personDAO.updatePerson(person);
    }

    @Transactional
    public List<Person> listPerson() {
        return personDAO.listPerson();
    }

    @Transactional
    public Person getPerson(int id) {
        return personDAO.getPerson(id);
    }

    @Transactional
    public void removePerson(int id) {
        personDAO.removePerson(id);
    }
}

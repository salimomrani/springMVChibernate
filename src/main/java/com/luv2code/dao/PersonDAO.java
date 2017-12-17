package com.luv2code.dao;

import com.luv2code.entity.Person;

import java.util.List;

/**
 * Created by salim on 15/10/17 2017 project springMVChibernate.
 */
public interface PersonDAO {

    void addPerson(Person person);

    void updatePerson(Person person);

    List<Person> listPerson();

    Person getPerson(int id);

    void removePerson(int id);
}

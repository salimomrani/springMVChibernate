package com.luv2code.dao;

import com.luv2code.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by salim on 15/10/17 2017 project springMVChibernate.
 */

@Repository
public class PersonDAOImpl implements PersonDAO {


    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addPerson(Person person) {
        Session session = sessionFactory.getCurrentSession();

        session.persist(person);
    }

    public void updatePerson(Person person) {

        Session session = sessionFactory.getCurrentSession();

        session.update(person);
    }

    public List<Person> listPerson() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Person>) session.createQuery("from Person ").getResultList();
    }

    public Person getPerson(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.load(Person.class,id);
    }

    public void removePerson(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = session.load(Person.class,id);
        if (person!= null){
            session.delete(person);
        }else {
            System.out.println("cette id ne correspond a personne");
        }

    }
}

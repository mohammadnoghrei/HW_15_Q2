package repository;

import connection.SessionFactorySingleton;
import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public void save(Person person){
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.merge(person);
        transaction.commit();
        session.close();
    }

    public Person findById(long id){
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Person person =session.get(Person.class,id);
        transaction.commit();
        session.close();
        return person;
    }

//    public List<Person> findAll(){
//        Session session = sessionFactory.openSession();
//        Transaction transaction=session.beginTransaction();
//        Query<Person> queryPerson = session.createQuery("from person", Person.class);
//        List<Person> personList = queryPerson.list();
//        transaction.commit();
//        session.close();
//        return personList;
//    }
        public List<Person> findAll(){
            Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
//        Query<Person> queryPerson = session.createQuery("from person", Person.class);
            Query<Person> queryPerson =session.createQuery("SELECT a FROM person a", Person.class);
            List<Person> personList = queryPerson.list();
        transaction.commit();
        session.close();
        return personList;
        }

    public void remove(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Person person =session.get(Person.class,id);
        session.remove(person);
        transaction.commit();
        session.close();
    }

        public void removePerson(Person person) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.remove(person);
            transaction.commit();
            session.close();
        }

    /////////////////////////********************
    public void update(Person person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(person);
        transaction.commit();
        session.close();
    }
}

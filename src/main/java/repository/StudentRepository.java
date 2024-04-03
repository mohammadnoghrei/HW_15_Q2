package repository;

import connection.SessionFactorySingleton;
import model.Person;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentRepository {
    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public void save(Student student){
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.merge(student);
        transaction.commit();
        session.close();
    }

    public Student findById(long id){
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Student student =session.get(Student.class,id);
        transaction.commit();
        session.close();
        return student;
    }


    public List<Student> findAll(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Student> queryStudent = session.createQuery("FROM Student", Student.class);
        List<Student> studentList = queryStudent.list();
        transaction.commit();
        session.close();
        return studentList;
    }

    public void remove(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student =session.get(Student.class,id);
        session.remove(student);
        transaction.commit();
        session.close();
    }

    public void removePerson(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(student);
        transaction.commit();
        session.close();
    }

    /////////////////////////********************
    public void update(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
    }
}

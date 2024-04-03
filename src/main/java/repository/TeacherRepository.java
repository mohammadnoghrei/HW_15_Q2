package repository;

import connection.SessionFactorySingleton;
import model.Student;
import model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TeacherRepository {

    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public void save(Teacher teacher){
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.merge(teacher);
        transaction.commit();
        session.close();
    }

    public Teacher findById(long id){
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Teacher teacher =session.get(Teacher.class,id);
        transaction.commit();
        session.close();
        return teacher;
    }


    public List<Teacher> findAll(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Teacher> queryStudent = session.createQuery("FROM Teacher ", Teacher.class);
        List<Teacher> teachers = queryStudent.list();
        transaction.commit();
        session.close();
        return teachers;
    }

    public void remove(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Teacher teacher =session.get(Teacher.class,id);
        session.remove(teacher);
        transaction.commit();
        session.close();
    }

    public void removeTeacher(Teacher teacher) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(teacher);
        transaction.commit();
        session.close();
    }

    /////////////////////////********************
    public void update(Teacher teacher) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(teacher);
        transaction.commit();
        session.close();
    }
}

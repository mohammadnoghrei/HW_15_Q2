import model.Person;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import service.PersonService;
import service.StudentService;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        StandardServiceRegistry build = new StandardServiceRegistryBuilder().configure().build();
//        SessionFactory sessionFactory = new MetadataSources(build)
//                .addAnnotatedClass(Person.class)
//                .buildMetadata().buildSessionFactory();
//
//        Person person = new Person(1,"ali","alavi");
//        Session session=sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.persist(person);
//        transaction.commit();

        Person person=new Person("k","al", new Date(97,6,7));
        PersonService personService=new PersonService();
        StudentService studentService=new StudentService();
        java.sql.Date sqldate = java.sql.Date.valueOf("1997-5-5");
        java.sql.Date sqldate2 = java.sql.Date.valueOf("1997-5-5");
        Student student =new Student("m","m",sqldate,123456l,"dd",sqldate2);

        studentService.save(student);
        List<Student> studentList=studentService.findAll();
        studentList.forEach(System.out::println);
        //        personService.save(person);
//            personService.update(person);
//        personService.remove(2);
//        List<Person> personList=personService.findAll();

    }
}

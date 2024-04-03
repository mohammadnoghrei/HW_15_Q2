package connection;

import model.Person;
import model.Student;
import model.Teacher;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class SessionFactorySingleton {
        private SessionFactorySingleton() {}
        private static class LazyHolder {
            static SessionFactory INSTANCE;
            static {
                var registry = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();
                INSTANCE = new MetadataSources(registry)
                        .addAnnotatedClass(Person.class)
                        .addAnnotatedClass(Student.class)
                        .addAnnotatedClass(Teacher.class)
                        .buildMetadata()
                        .buildSessionFactory();
            }
        }
        public static SessionFactory getInstance() {
            return LazyHolder.INSTANCE;
        }
    }


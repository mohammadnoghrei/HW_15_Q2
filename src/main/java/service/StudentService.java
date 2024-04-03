package service;

import model.Person;
import model.Student;
import repository.PersonRepository;
import repository.StudentRepository;

import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository=new StudentRepository();
    public void save(Student student){
        studentRepository.save(student);
    }
    public void update(Student student){
        studentRepository.update(student);
    }

    public void remove(long id){
        Student student =studentRepository.findById(id);
        studentRepository.removePerson(student);
    }
    //    public void removePerson(Person person){
//        personRepository.removePerson(person);
//    }
    public List<Student> findAll(){
        return studentRepository.findAll();
    }
    public Student contains(int id){return studentRepository.findById(id);}
}

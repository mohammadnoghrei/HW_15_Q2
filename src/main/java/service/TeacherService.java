package service;

import model.Student;
import model.Teacher;
import repository.StudentRepository;
import repository.TeacherRepository;

import java.util.List;

public class TeacherService {
    private final TeacherRepository teacherRepository=new TeacherRepository();
    public void save(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public void update(Teacher teacher){teacherRepository.update(teacher);}

    public void remove(long id){
        Teacher teacher =teacherRepository.findById(id);
        teacherRepository.removeTeacher(teacher);
    }
    //    public void removePerson(Person person){
//        personRepository.removePerson(person);
//    }
    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }
    public Teacher contains(int id){return teacherRepository.findById(id);}
}

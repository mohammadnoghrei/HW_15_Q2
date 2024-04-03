package service;

import model.MASTER_DEGREE;
import model.Person;
import model.Student;
import model.Teacher;
import repository.StudentRepository;
import repository.TeacherRepository;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
    public Boolean contains(int id) {
        if (teacherRepository.findById(id) == null)
            return false;
        else return true;
    }



    public void teachersingUp(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter first name");
        String firstName= scanner.next();
        scanner.nextLine();
        System.out.println("please enter last name");
        String lastName=scanner.next();
        scanner.nextLine();
        System.out.println("please enter your birth date");
        String birthDate=scanner.next();
        scanner.nextLine();
        java.sql.Date sqldate = java.sql.Date.valueOf(birthDate);
        System.out.println("please enter teacher code");
        long teacherCode= scanner.nextInt();
        System.out.println("please enter salary");
        int salary=scanner.nextInt();
        scanner.nextLine();
        System.out.println("please enter diploma");
        String diploma=scanner.next();
        System.out.println("please enter master degree (A'B'C)");
        String masterDegree=scanner.next();
        scanner.nextLine();
        MASTER_DEGREE master_degree;
        switch (masterDegree.toLowerCase()){
            case "a"->{master_degree=MASTER_DEGREE.A;}
            case "b"->{master_degree=MASTER_DEGREE.B;}
            case "c"->{master_degree=MASTER_DEGREE.C;}
            default -> {master_degree=MASTER_DEGREE.NoDegree;}
        }
        Teacher teacher =new Teacher(firstName,lastName,sqldate,teacherCode,salary,diploma,master_degree);
        teacherRepository.save(teacher);
    }
}

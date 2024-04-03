package menu;

import model.Student;
import service.StudentService;
import service.TeacherService;

import java.util.List;
import java.util.Scanner;

public class StudentMenu {
    Scanner scanner = new Scanner(System.in);
    private  StudentService studentService= new StudentService();
    private TeacherService teacherService=new TeacherService();
    public void studentSingUp(){
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
        System.out.println("please enter student code");
        long studentCode= scanner.nextInt();
        System.out.println("please enter study");
        String study =scanner.next();
        scanner.nextLine();
        System.out.println("please enter enter date");
        String enterDate=scanner.next();
        scanner.nextLine();
        java.sql.Date sqlenterdate = java.sql.Date.valueOf(enterDate);

        Student student =new Student(firstName,lastName,sqldate,studentCode,study,sqlenterdate);
        studentService.save(student);
        System.out.println("student saved");
    }
    public void studentUpdate(){
        System.out.println("please enter id for update");
        int id =scanner.nextInt();
        if (studentService.contains(id)){
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
        System.out.println("please enter student code");
        long studentCode= scanner.nextInt();
        System.out.println("please enter study");
        String study =scanner.next();
        scanner.nextLine();
        System.out.println("please enter enter date");
        String enterDate=scanner.next();
        scanner.nextLine();
        java.sql.Date sqlenterdate = java.sql.Date.valueOf(enterDate);

        Student student =new Student(id,firstName,lastName,sqldate,studentCode,study,sqlenterdate);
        studentService.update(student);
            System.out.println("student updated");}
        else System.out.println("this id not exist");
    }
    public void studentDelete(){
        System.out.println("please enter id for delete");
        int id =scanner.nextInt();
        if (studentService.contains(id)){
            studentService.remove(id);
        System.out.println("removed student");}
        else System.out.println("this id not exist");
    }
    public void studentLoadAll(){
        List<Student> studentList=studentService.findAll();
        studentList.stream().toString();
    }
    public void studentBaseMenu(){
        System.out.println("**********  student menu ************");
        System.out.println("1:save  2:update  3:delete 4:loadAll");
        System.out.println("please enter a number");
        int choose=scanner.nextInt();
    switch (choose){
        case 1:studentSingUp();break;
        case 2:studentUpdate();break;
        case 3:studentDelete();break;
        case 4:studentLoadAll();break;
    }

    }
}

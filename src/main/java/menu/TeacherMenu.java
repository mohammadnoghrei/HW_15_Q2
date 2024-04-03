package menu;

import model.MASTER_DEGREE;
import model.Student;
import model.Teacher;
import service.StudentService;
import service.TeacherService;

import java.util.List;
import java.util.Scanner;

public class TeacherMenu {
    Scanner scanner = new Scanner(System.in);
    private StudentService studentService= new StudentService();
    private TeacherService teacherService=new TeacherService();
    public void teacherSingUp(){
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
        teacherService.save(teacher);
    }
    public void teacherUpdate(){
        System.out.println("please enter id for update");
        int id =scanner.nextInt();
        if (teacherService.contains(id)){
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
            Teacher teacher =new Teacher(id,firstName,lastName,sqldate,teacherCode,salary,diploma,master_degree);
            teacherService.save(teacher);
            System.out.println("teacher updated");}
        else System.out.println("this id not exist");
    }
    public void teacherDelete(){
        System.out.println("please enter id for delete");
        int id =scanner.nextInt();
        if (teacherService.contains(id)){
            teacherService.remove(id);
            System.out.println("removed teacher");}
        else System.out.println("this id not exist");
    }
    public void teacherLoadAll(){
        List<Teacher> studentList=teacherService.findAll();
        studentList.stream().toString();
    }
    public void teacherBaseMenu(){
        System.out.println("*********** Teacher menu **********");
        System.out.println("1:save  2:update  3:delete 4:loadAll");
        System.out.println("please enter a number");
        int choose=scanner.nextInt();
        switch (choose){
            case 1:teacherSingUp();break;
            case 2:teacherUpdate();break;
            case 3:teacherDelete();break;
            case 4:teacherLoadAll();break;
        }

    }
}

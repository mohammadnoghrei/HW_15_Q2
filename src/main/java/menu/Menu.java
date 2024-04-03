package menu;

import java.util.Scanner;

public class Menu {
    TeacherMenu teacherMenu=new TeacherMenu();
    StudentMenu studentMenu=new StudentMenu();

    Scanner scanner = new Scanner(System.in);
    public void baseMenu(){
        boolean end = true;
        while (end){
        System.out.println("*************** start menu *************");
        System.out.println("1:Teacher menu  2:Student menu   0:Exit");
        System.out.println("please enter a number");
        int choose=scanner.nextInt();
        switch (choose){
            case 1:teacherMenu.teacherBaseMenu();break;
            case 2:studentMenu.studentBaseMenu();break;
            case 0:end=false;
            default:
                System.out.println("please enter valid number ");
        }
    }
    }












}

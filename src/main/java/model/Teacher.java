package model;

import jakarta.persistence.Entity;

@Entity
public class Teacher extends Person {
    long teacherCode;
    int salary;
    String  diploma;



}
enum MASTER_DEGREE{

}
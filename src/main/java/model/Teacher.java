package model;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Teacher extends Person {
    long teacherCode;
    int salary;
    String  diploma;
    MASTER_DEGREE masterDegree;



    public Teacher(String firstName, String lastName, Date birthDate, long teacherCode, int salary, String diploma, MASTER_DEGREE masterDegree) {
        super(firstName, lastName, birthDate);
        this.teacherCode = teacherCode;
        this.salary = salary;
        this.diploma = diploma;
        this.masterDegree = masterDegree;
    }

    public Teacher(Integer id, String firstName, String lastName, Date birthDate, long teacherCode, int salary, String diploma, MASTER_DEGREE masterDegree) {
        super(id, firstName, lastName, birthDate);
        this.teacherCode = teacherCode;
        this.salary = salary;
        this.diploma = diploma;
        this.masterDegree = masterDegree;
    }

    public Teacher(long teacherCode, int salary, String diploma, MASTER_DEGREE masterDegree) {
        this.teacherCode = teacherCode;
        this.salary = salary;
        this.diploma = diploma;
        this.masterDegree = masterDegree;
    }
}


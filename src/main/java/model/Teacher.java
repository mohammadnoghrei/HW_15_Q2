package model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
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
}


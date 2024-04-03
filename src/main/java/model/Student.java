package model;


import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Student extends Person{
    long studentCode;
    String study;
    @Temporal(TemporalType.DATE)
    Date enterDate;

    public Student(Integer id, String firstName, String lastName, Date birthDate, long studentCode, String study, Date enterDate) {
        super(id, firstName, lastName, birthDate);
        this.studentCode = studentCode;
        this.study = study;
        this.enterDate = enterDate;
    }

    public Student(long studentCode, String study, Date enterDate) {
        this.studentCode = studentCode;
        this.study = study;
        this.enterDate = enterDate;
    }

    public Student(String firstName, String lastName, Date birthDate, long studentCode, String study, Date enterDate) {
        super(firstName, lastName, birthDate);
        this.studentCode = studentCode;
        this.study = study;
        this.enterDate = enterDate;
    }
}

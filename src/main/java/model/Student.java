package model;


import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
public class Student extends Person{
    long studentCode;
    String study;
    @Temporal(TemporalType.DATE)
    Date enterDate;

    public Student(String firstName, String lastName, Date birthDate, long studentCode, String study, Date enterDate) {
        super(firstName, lastName, birthDate);
        this.studentCode = studentCode;
        this.study = study;
        this.enterDate = enterDate;
    }
}

package unibe.edu.ec.matricula.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Student extends Person {


    private boolean status;


    @JoinTable(
            name = "student_collegeCarrer",
            joinColumns = @JoinColumn(name="student",nullable = false),
            inverseJoinColumns = @JoinColumn(name="collegeCarrer", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<CollegeCarrer> collegeCarrers;

    public Student() {

    }


    public Student(String id, String name, String address, String phoneNumber, String email, Date birthDate, boolean status) {
        super(id, name, address, phoneNumber, email, birthDate);
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "status=" + status +
                '}';
    }
}

package unibe.edu.ec.matricula.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Student extends Person {


    private boolean status;

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

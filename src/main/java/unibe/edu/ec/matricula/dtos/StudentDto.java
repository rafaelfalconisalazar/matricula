package unibe.edu.ec.matricula.dtos;

import unibe.edu.ec.matricula.entities.CollegeCarrer;
import unibe.edu.ec.matricula.entities.Student;

import java.util.Date;
import java.util.List;

public class StudentDto {

    private String id;

    private String name,address, phoneNumber,email;

    private Date birthDate;

    private boolean status;

    private List<CollegeCarrerDto> collegeCarrerDtos;

    public StudentDto(){

    }

    public StudentDto(String id, String name, String address, String phoneNumber, String email, Date birthDate, boolean status, List<CollegeCarrerDto> collegeCarrerDtos) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate = birthDate;
        this.status = status;
        this.collegeCarrerDtos = collegeCarrerDtos;
    }

    public  StudentDto(Student student){
        this.id=student.getId();
        this.name=student.getName();
        this.address=student.getAddress();
        this.phoneNumber=student.getPhoneNumber();
        this.email=student.getEmail();
        this.status=student.isStatus();
        this.birthDate=student.getBirthDate();
        for ( CollegeCarrer collegeCarrer: student.getCollegeCarrers()) {
            CollegeCarrerDto collegeCarrerDto= new CollegeCarrerDto(collegeCarrer);
            this.collegeCarrerDtos.add(collegeCarrerDto);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<CollegeCarrerDto> getCollegeCarrerDtos() {
        return collegeCarrerDtos;
    }

    public void setCollegeCarrerDtos(List<CollegeCarrerDto> collegeCarrerDtos) {
        this.collegeCarrerDtos = collegeCarrerDtos;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", status=" + status +
                ", collegeCarrerDtos=" + collegeCarrerDtos +
                '}';
    }
}

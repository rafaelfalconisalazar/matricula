package unibe.edu.ec.matricula.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import unibe.edu.ec.matricula.dtos.StudentDto;
import unibe.edu.ec.matricula.entities.CollegeCarrer;
import unibe.edu.ec.matricula.entities.Parallel;
import unibe.edu.ec.matricula.entities.Student;
import unibe.edu.ec.matricula.repositories.StudentRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    public void crateStudent(StudentDto studentDto) throws ParseException {
        List<CollegeCarrer> collegeCarrers = new ArrayList<CollegeCarrer>();
        List<Parallel> parallels = new ArrayList<Parallel>();
        Date birthdate;

        birthdate = new SimpleDateFormat("dd/MM/yyyy").parse(studentDto.getBirthDate());

        Student student = new Student(studentDto.getId(), studentDto.getName(),
                studentDto.getAddress(), studentDto.getPhoneNumber(),
                studentDto.getEmail(), birthdate, studentDto.isStatus(), collegeCarrers, parallels);
        this.studentRepository.save(student);
    }

    public List<StudentDto> readStudentAll() {
        List<Student> studentList = this.studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<StudentDto>();
        for (Student student : studentList) {
            studentDtos.add(new StudentDto(student));
        }
        return studentDtos;
    }
}

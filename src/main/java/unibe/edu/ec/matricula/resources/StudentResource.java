package unibe.edu.ec.matricula.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import unibe.edu.ec.matricula.controllers.StudentController;
import unibe.edu.ec.matricula.dtos.StudentDto;
import unibe.edu.ec.matricula.resources.exeptions.DateFormatInvalidad;
import unibe.edu.ec.matricula.resources.exeptions.StudentAllReadyExist;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(StudentResource.STUDENT)
public class StudentResource {

    public static final String STUDENT = "/students";

    @Autowired
    private StudentController studentController;

    @PostMapping
    public void createStudent(@Valid @RequestBody StudentDto studentDto) throws StudentAllReadyExist, DateFormatInvalidad {
        try {
            this.studentController.crateStudent(studentDto);
        } catch (ParseException e) {
            throw new DateFormatInvalidad("",1);
        }

        //return studentDto.toString();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<StudentDto> readStudentAll() {
        return this.studentController.readStudentAll();
    }
}

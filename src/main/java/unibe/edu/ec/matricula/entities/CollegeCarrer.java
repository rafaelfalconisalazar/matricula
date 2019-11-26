package unibe.edu.ec.matricula.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class CollegeCarrer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int semester;

    @OneToOne(cascade = CascadeType.ALL)
    private Teacher decade;

    @ManyToMany(mappedBy = "collegeCarrers")
    private List<Student> students;
}

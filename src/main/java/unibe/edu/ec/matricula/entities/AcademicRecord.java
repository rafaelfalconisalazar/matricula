package unibe.edu.ec.matricula.entities;

import javax.persistence.*;

@Entity
public class AcademicRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Student student;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Subject subject;

    private double note;
}

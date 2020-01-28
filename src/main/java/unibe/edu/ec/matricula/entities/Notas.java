package unibe.edu.ec.matricula.entities;

import javax.persistence.*;

@Entity
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Parallel parallel;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Student student;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Actividad actividad;
    private double nota;

    public Notas(int id, Parallel parallel, Student student, Actividad actividad, double nota) {
        this.id = id;
        this.parallel = parallel;
        this.student = student;
        this.actividad = actividad;
        this.nota = nota;
    }

    public Notas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Parallel getParallel() {
        return parallel;
    }

    public void setParallel(Parallel parallel) {
        this.parallel = parallel;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}

package unibe.edu.ec.matricula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unibe.edu.ec.matricula.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
}

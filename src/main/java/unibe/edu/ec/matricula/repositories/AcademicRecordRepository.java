package unibe.edu.ec.matricula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unibe.edu.ec.matricula.entities.AcademicRecord;

public interface AcademicRecordRepository extends JpaRepository<AcademicRecord,Integer> {
}

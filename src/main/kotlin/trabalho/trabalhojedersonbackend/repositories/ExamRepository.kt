package trabalho.trabalhojedersonbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalho.trabalhojedersonbackend.enums.ExamStatusEnum
import trabalho.trabalhojedersonbackend.model.Exam;

@Repository
public interface ExamRepository : JpaRepository<Exam, Long> {

//    fun findByName(name: String): Exam

    fun findByStatus(status: ExamStatusEnum): List<Exam>

    fun findByStatusAndPatientId(status: ExamStatusEnum,patientId: Long): List<Exam>

//    fun findByNameAndStatus(name: String,status: String): Exam

}

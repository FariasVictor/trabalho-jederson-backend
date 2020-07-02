package trabalho.trabalhojedersonbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalho.trabalhojedersonbackend.enums.ExamStatusEnum
import trabalho.trabalhojedersonbackend.model.Exam;

@Repository
public interface ExamRepository: JpaRepository<Exam, Long> {

    fun findByStatus(status: ExamStatusEnum): List<Exam>

    //Buscar todos os exames de cada entidade
    fun findByPatientId(patientId: Long): List<Exam>
    fun findByClinicId(clinicId: Long): List<Exam>
    fun findByDoctorId(doctorId: Long): List<Exam>

    //Buscar os exames do usuário logado por status
    fun findByStatusAndPatientId(status: ExamStatusEnum, patientId: Long): List<Exam>
    fun findByStatusAndClinicId(status: ExamStatusEnum, clinicId: Long): List<Exam>
    fun findByStatusAndDoctorId(status: ExamStatusEnum, doctorId: Long): List<Exam>

    fun findByClinicIdAndDoctorId(clinicId: Long, doctorId: Long): List<Exam>
    fun findByClinicIdAndPatientId(clinicId: Long, patientId: Long): List<Exam>
}

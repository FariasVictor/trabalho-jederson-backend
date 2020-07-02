package trabalho.trabalhojedersonbackend.services

import trabalho.trabalhojedersonbackend.enums.ExamStatusEnum
import trabalho.trabalhojedersonbackend.enums.UserTypeEnum
import trabalho.trabalhojedersonbackend.model.Exam
import trabalho.trabalhojedersonbackend.model.ExamData
import trabalho.trabalhojedersonbackend.model.request.ExamDataRequest

interface ExamService {

    fun findAll(): List<Exam>?

    fun findById(id: Long): Exam?



    fun findUserAllExams(userType: UserTypeEnum, userId: Long): List<Exam>
    fun findAllByPatientId(patientId: Long): List<Exam>
    fun findAllByClinicId(clinicId: Long): List<Exam>
    fun findAllByDoctorId(doctorId: Long): List<Exam>

    //Direciona a busca pro tipo de usuário certo(Clinica, paciente ou médico)
    fun findUserExamsByStatus(userType: UserTypeEnum, userId: Long, status: ExamStatusEnum): List<Exam>

    //Buscar os exames do usuário logado por status
    fun findPatientExamsByStatus(patientId: Long, status: ExamStatusEnum): List<Exam>
    fun findClinicExamsByStatus(clinicId: Long, status: ExamStatusEnum): List<Exam>
    fun findDoctorExamsByStatus(doctorId: Long, status: ExamStatusEnum): List<Exam>

    fun clinicFindByUser(clinicId: Long, userType: UserTypeEnum, userId: Long): List<Exam>
    fun clinicFindByPatient(clinicId: Long, patientId: Long): List<Exam>
    fun clinicFindByDoctor(clinicId: Long, doctorId: Long): List<Exam>

    fun save(exam: Exam): Exam?

    fun deleteById(id: Long)

    fun update(id: Long, examDataRequests: List<ExamDataRequest>): Exam
}
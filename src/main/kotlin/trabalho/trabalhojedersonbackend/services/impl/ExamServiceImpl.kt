package trabalho.trabalhojedersonbackend.services.impl;

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils.isEmpty
import trabalho.trabalhojedersonbackend.enums.ExamStatusEnum
import trabalho.trabalhojedersonbackend.enums.UserTypeEnum
import trabalho.trabalhojedersonbackend.exceptions.BadRequestException
import trabalho.trabalhojedersonbackend.exceptions.ExamAlreadyAnalisedException
import trabalho.trabalhojedersonbackend.model.Exam
import trabalho.trabalhojedersonbackend.model.ExamData
import trabalho.trabalhojedersonbackend.repositories.ExamRepository
import trabalho.trabalhojedersonbackend.services.ExamService
import java.time.LocalDateTime
import javax.persistence.EntityNotFoundException

@Service
class ExamServiceImpl(val examRepository: ExamRepository) : ExamService {

    override fun findAll(): List<Exam>? = examRepository.findAll()

    override fun findById(id: Long): Exam? = examRepository.findByIdOrNull(id)

    override fun findUserAllExams(userType: UserTypeEnum, userId: Long): List<Exam> {
        return when (userType) {
            UserTypeEnum.CLINIC -> {
                findAllByClinicId(userId)
            }
            UserTypeEnum.DOCTOR -> {
                findAllByDoctorId(userId)
            }
            UserTypeEnum.PATIENT -> {
                findAllByPatientId(userId)
            }
        }
    }

    override fun findAllByPatientId(patientId: Long): List<Exam> {
        return examRepository.findByPatientId(patientId)
    }

    override fun findAllByClinicId(clinicId: Long): List<Exam> {
        return examRepository.findByClinicId(clinicId)
    }

    override fun findAllByDoctorId(doctorId: Long): List<Exam> {
        return examRepository.findByDoctorId(doctorId)
    }

    override fun findUserExamsByStatus(userType: UserTypeEnum, userId: Long, status: ExamStatusEnum): List<Exam> {
        return when (userType) {
            UserTypeEnum.CLINIC -> {
                findClinicExamsByStatus(userId, status)
            }
            UserTypeEnum.DOCTOR -> {
                findDoctorExamsByStatus(userId, status)
            }
            UserTypeEnum.PATIENT -> {
                findPatientExamsByStatus(userId, status)
            }
        }
    }

    override fun findPatientExamsByStatus(patientId: Long, status: ExamStatusEnum): List<Exam> {
        return examRepository.findByStatusAndPatientId(status, patientId)
    }

    override fun findClinicExamsByStatus(clinicId: Long, status: ExamStatusEnum): List<Exam> {
        return examRepository.findByStatusAndClinicId(status, clinicId)
    }

    override fun findDoctorExamsByStatus(doctorId: Long, status: ExamStatusEnum): List<Exam> {
        return examRepository.findByStatusAndDoctorId(status, doctorId)
    }

    override fun clinicFindByUser(clinicId: Long, userType: UserTypeEnum, userId: Long): List<Exam> {
        return when (userType) {
            UserTypeEnum.PATIENT -> {
                clinicFindByPatient(clinicId, userId)
            }
            UserTypeEnum.DOCTOR -> {
                clinicFindByDoctor(clinicId, userId)
            }
            else -> throw BadRequestException("Tipos permitidos são médico e paciente")
        }
    }

    override fun clinicFindByPatient(clinicId: Long, patientId: Long): List<Exam> {
        return examRepository.findByClinicIdAndPatientId(clinicId, patientId)
    }

    override fun clinicFindByDoctor(clinicId: Long, doctorId: Long): List<Exam> {
        return examRepository.findByClinicIdAndDoctorId(clinicId, doctorId)
    }

    override fun save(exam: Exam): Exam? {
        exam.status = ExamStatusEnum.EXAME_EM_ANDAMENTO
        return examRepository.save(exam)
    }

    override fun update(id: Long, examData: List<ExamData>?): Exam {
        examRepository.findByIdOrNull(id)?.let { exam ->
            if (exam.status == ExamStatusEnum.EXAME_EM_ANDAMENTO && !isEmpty(examData)) {
                exam.status = ExamStatusEnum.EXAME_CONCLUIDO
                exam.examCompletedDate = LocalDateTime.now()
                exam.examData = examData
                return examRepository.save(exam)
            } else if (exam.status == ExamStatusEnum.EXAME_CONCLUIDO) {
                exam.status = ExamStatusEnum.EXAME_ANALISADO
                return examRepository.save(exam)
            }
            throw ExamAlreadyAnalisedException()
        } ?: throw EntityNotFoundException()
    }

    override fun deleteById(id: Long) = examRepository.deleteById(id)
}

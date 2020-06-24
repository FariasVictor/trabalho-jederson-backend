package trabalho.trabalhojedersonbackend.services.impl;

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service;
import trabalho.trabalhojedersonbackend.enums.ExamStatusEnum
import trabalho.trabalhojedersonbackend.enums.UserTypeEnum
import trabalho.trabalhojedersonbackend.exceptions.ExamAlreadyAnalisedException
import trabalho.trabalhojedersonbackend.model.Exam
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
        return examRepository.findByPatientId(patientId).let {
            if (it.isEmpty()) throw EntityNotFoundException()
            else it
        }
    }

    override fun findAllByClinicId(clinicId: Long): List<Exam> {
        return examRepository.findByClinicId(clinicId).let {
            if(it.isEmpty()) throw EntityNotFoundException()
            else it
        }
    }

    override fun findAllByDoctorId(doctorId: Long): List<Exam> {
        return examRepository.findByDoctorId(doctorId).let {
            if(it.isEmpty()) throw EntityNotFoundException()
            else it
        }
    }

    override fun findUserExamsByStatus(userType: UserTypeEnum, userId: Long, status: ExamStatusEnum): List<Exam> {
        return when (userType) {
            UserTypeEnum.CLINIC -> {
                findClinicExamsByStatus(userId,status)
            }
            UserTypeEnum.DOCTOR -> {
                findDoctorExamsByStatus(userId,status)
            }
            UserTypeEnum.PATIENT -> {
                findPatientExamsByStatus(userId,status)
            }
        }
    }

    override fun findPatientExamsByStatus(patientId: Long, status: ExamStatusEnum): List<Exam> {
        return examRepository.findByStatusAndPatientId(status, patientId).let {
            if (it.isEmpty()) throw EntityNotFoundException()
            else it
        }
    }

    override fun findClinicExamsByStatus(clinicId: Long, status: ExamStatusEnum): List<Exam> {
        return examRepository.findByStatusAndClinicId(status, clinicId).let {
            if (it.isEmpty()) throw EntityNotFoundException()
            else it
        }
    }

    override fun findDoctorExamsByStatus(doctorId: Long, status: ExamStatusEnum): List<Exam> {
        return examRepository.findByStatusAndDoctorId(status, doctorId).let {
            if (it.isEmpty()) throw EntityNotFoundException()
            else it
        }
    }

    override fun save(exam: Exam): Exam? {
        exam.status = ExamStatusEnum.EXAME_EM_ANDAMENTO
        return examRepository.save(exam)
    }

    //NAO TESTADO, N FAÇO IDEIA SE TÁ FUNCIONANDO CERTO, NA MINHA CABEÇA RODOU KKKK
    override fun update(id: Long): Exam {
        examRepository.findByIdOrNull(id)?.let { exam ->
            if (exam.status == (ExamStatusEnum.EXAME_EM_ANDAMENTO)) {
                exam.status = ExamStatusEnum.EXAME_CONCLUIDO
                exam.examCompletedDate = LocalDateTime.now()
                return examRepository.save(exam)
            } else if (exam.status == (ExamStatusEnum.EXAME_CONCLUIDO)) {
                exam.status = ExamStatusEnum.EXAME_ANALISADO
                return examRepository.save(exam)
            }
            throw ExamAlreadyAnalisedException()
        } ?: throw EntityNotFoundException()
    }

    override fun deleteById(id: Long) = examRepository.deleteById(id)
}

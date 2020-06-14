package trabalho.trabalhojedersonbackend.services.impl;

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service;
import trabalho.trabalhojedersonbackend.enums.ExamStatusEnum
import trabalho.trabalhojedersonbackend.exceptions.BadRequestException
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

    //NÃO CONSEGUI FAZER A BUSCA POR NOME, ACHO QUE TEM BUSCAR PELA PESSOA
    //POR STATUS TESTEI AQUI E TÁ FUNCIONANDO
    override fun findFiltered(name: String?, status: ExamStatusEnum?): List<Exam>? {
        return if (/*name.isNullOrBlank() &&*/ status == null) throw BadRequestException("Nome ou status deve ser preenchido")
//        else if(name!!.isNotBlank() && status!!.isNotBlank()) examRepository.findByNameAndStatus(name, status)
//        else if (name!!.isNotBlank()) examRepository.findByName(name)
        else examRepository.findByStatus(status)
    }

    //patient + status tá funcionando
    override fun findPatientExamsFiltered(patientId: Long, type: String?, status: ExamStatusEnum?): List<Exam>? {
        return examRepository.findByStatusAndPatientId(status!!,patientId)
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
                exam.emissionDate = LocalDateTime.now()
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
//
//package trabalho.trabalhojedersonbackend.services.impl;
//
//import org.springframework.data.repository.findByIdOrNull
//import org.springframework.stereotype.Service;
//import trabalho.trabalhojedersonbackend.enums.ExamStatusEnum
//import trabalho.trabalhojedersonbackend.model.Exam
//import trabalho.trabalhojedersonbackend.repositories.ExamRepository
//import trabalho.trabalhojedersonbackend.services.ExamService
//
//@Service
//class ExamServiceImpl(val examRepository: ExamRepository) : ExamService {
//
//    override fun findAll(): List<Exam>? = examRepository.findAll()
//
//    override fun findById(id: Long): Exam? = examRepository.findByIdOrNull(id)
//
//    override fun save(exam: Exam): Exam {
//        if (exam.status.equals("EXAME_EM_ANDAMENTO")) {
//            Exam(
//                    status = ExamStatusEnum.EXAME_CONCLUIDO
//            )
//            return examRepository.save(exam)
//        } else if (exam.status.equals("EXAME_CONCLUIDO")) {
//            Exam(
//                    status = ExamStatusEnum.EXAME_ANALISADO
//            )
//            return examRepository.save(exam)
//        }
//        Exam(
//                requestDate = null,
//                emissionDate = null,
//                type = "Sangue",
//                status = ExamStatusEnum.EXAME_EM_ANDAMENTO,
//                patient = null,
//                doctor = null,
//                clinic = null
//        )
//        return examRepository.save(exam)
//    }
//
//    override fun deleteById(id: Long) = examRepository.deleteById(id)
//}
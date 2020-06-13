package trabalho.trabalhojedersonbackend.services.impl;

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service;
import trabalho.trabalhojedersonbackend.enums.ExamStatusEnum
import trabalho.trabalhojedersonbackend.model.Exam
import trabalho.trabalhojedersonbackend.repositories.ExamRepository
import trabalho.trabalhojedersonbackend.services.ExamService

@Service
class ExamServiceImpl(val examRepository: ExamRepository) : ExamService {

    override fun findAll(): List<Exam>? = examRepository.findAll()

    override fun findById(id: Long): Exam? = examRepository.findByIdOrNull(id)

    override fun save(exam: Exam): Exam {
        if (exam.status.equals("EXAME_EM_ANDAMENTO")) {
            Exam(
                    status = ExamStatusEnum.EXAME_CONCLUIDO
            )
            return examRepository.save(exam)
        } else if (exam.status.equals("EXAME_CONCLUIDO")) {
            Exam(
                    status = ExamStatusEnum.EXAME_ANALISADO
            )
            return examRepository.save(exam)
        }
        Exam(
                requestDate = null,
                emissionDate = null,
                type = "Sangue",
                status = ExamStatusEnum.EXAME_EM_ANDAMENTO,
                patient = null,
                doctor = null,
                clinic = null
        )
        return examRepository.save(exam)
    }

    override fun deleteById(id: Long) = examRepository.deleteById(id)
}

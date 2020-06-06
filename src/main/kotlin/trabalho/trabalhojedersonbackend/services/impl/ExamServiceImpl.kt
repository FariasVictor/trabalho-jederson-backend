package trabalho.trabalhojedersonbackend.services.impl;

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service;
import trabalho.trabalhojedersonbackend.model.Exam
import trabalho.trabalhojedersonbackend.repositories.ExamRepository
import trabalho.trabalhojedersonbackend.services.ExamService

@Service
class ExamServiceImpl(val examRepository: ExamRepository) : ExamService {

    override fun findAll(): List<Exam>? = examRepository.findAll()

    override fun findById(id: Long): Exam? = examRepository.findByIdOrNull(id)

    override fun save(exam: Exam): Exam = examRepository.save(exam)

    override fun deleteById(id: Long) = examRepository.deleteById(id)
}

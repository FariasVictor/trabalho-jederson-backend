package trabalho.trabalhojedersonbackend.services

import trabalho.trabalhojedersonbackend.enums.ExamStatusEnum
import trabalho.trabalhojedersonbackend.model.Exam

interface ExamService {

    fun findAll(): List<Exam>?

    fun findById(id: Long): Exam?

    fun findFiltered(name: String?, status: ExamStatusEnum?): List<Exam>?

    fun save(exam: Exam): Exam?

    fun deleteById(id: Long)

    fun update(exam: Exam): Exam
}
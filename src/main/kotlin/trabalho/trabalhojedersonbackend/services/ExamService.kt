package trabalho.trabalhojedersonbackend.services

import trabalho.trabalhojedersonbackend.model.Exam

interface ExamService {

    fun findAll(): List<Exam>?

    fun findById(id: Long): Exam?

    fun save(exam: Exam): Exam

    fun deleteById(id: Long)
}
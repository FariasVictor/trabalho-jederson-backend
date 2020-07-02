package trabalho.trabalhojedersonbackend.mapper

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import trabalho.trabalhojedersonbackend.exceptions.BadRequestException
import trabalho.trabalhojedersonbackend.model.ExamData
import trabalho.trabalhojedersonbackend.model.request.ExamDataRequest
import trabalho.trabalhojedersonbackend.repositories.ExamRepository

@Component
class ExamDataMapper(val examRepository: ExamRepository) {

    fun toExamData(examDataRequest: ExamDataRequest): ExamData {
        val examData = ExamData()
        examData.key=examDataRequest.key
        examData.value=examDataRequest.value
        examData.exam=examRepository.findByIdOrNull(examDataRequest.examId)?: throw BadRequestException("Informe o Exame")
        return examData
    }
}
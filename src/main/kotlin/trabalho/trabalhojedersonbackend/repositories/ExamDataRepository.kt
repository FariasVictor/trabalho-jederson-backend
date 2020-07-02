package trabalho.trabalhojedersonbackend.repositories

import org.springframework.data.jpa.repository.JpaRepository
import trabalho.trabalhojedersonbackend.model.ExamData

interface ExamDataRepository: JpaRepository<ExamData, Long> {
}
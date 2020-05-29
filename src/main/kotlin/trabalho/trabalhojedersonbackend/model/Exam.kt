package trabalho.trabalhojedersonbackend.model

import trabalho.trabalhojedersonbackend.enums.StatusExamEnum
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Exam(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        val requestDate: LocalDateTime,
        val emissionDate: LocalDateTime,
        val type: String,
        val statusExam: StatusExamEnum
) {

}
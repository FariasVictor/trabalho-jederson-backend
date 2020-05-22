package trabalho.trabalhojedersonbackend.model

import trabalho.trabalhojedersonbackend.enums.StatusEnum
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
        val data: Map<String, String>,
        val patient: Patient,
        val doctor: Doctor,
        val clinic: Clinic,
        val status: StatusEnum
) {
}
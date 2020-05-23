package trabalho.trabalhojedersonbackend.model

import org.hibernate.annotations.CreationTimestamp
import trabalho.trabalhojedersonbackend.enums.StatusEnum
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Exam(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        @CreationTimestamp
        val requestDate: LocalDateTime,
        val emissionDate: LocalDateTime,
//        val data: Map<String, String>,

        @ManyToOne
        val patient: Patient,

        @ManyToOne
        val doctor: Doctor,

        @ManyToOne
        val clinic: Clinic,

        @Enumerated(EnumType.STRING)
        val status: StatusEnum
) {
}
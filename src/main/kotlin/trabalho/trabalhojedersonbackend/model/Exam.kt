package trabalho.trabalhojedersonbackend.model

import org.hibernate.annotations.CreationTimestamp

import trabalho.trabalhojedersonbackend.enums.ExamStatusEnum

import java.time.LocalDateTime

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Enumerated
import javax.persistence.EnumType

@Entity
data class Exam(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        @CreationTimestamp
        val requestDate: LocalDateTime,
        val emissionDate: LocalDateTime,
        val type: String,

        val statusExam: ExamStatusEnum,
//        val data: Map<String, String>,

        @ManyToOne
        val patient: Patient,

        @ManyToOne
        val doctor: Doctor,

        @ManyToOne
        val clinic: Clinic,

        @Enumerated(EnumType.STRING)
        val status: ExamStatusEnum) {
}
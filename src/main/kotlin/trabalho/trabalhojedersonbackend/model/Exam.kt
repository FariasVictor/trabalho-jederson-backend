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
import javax.persistence.OneToOne

@Entity
data class Exam(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,

        var examCompletedDate: LocalDateTime?,

        val type: String,

        @Enumerated(EnumType.STRING)
        var status: ExamStatusEnum?,

        @ManyToOne
        val examData: ExamData?,

        @ManyToOne
        val patient: Patient?,

        @ManyToOne
        val doctor: Doctor?,

        @ManyToOne
        val clinic: Clinic?) {

}
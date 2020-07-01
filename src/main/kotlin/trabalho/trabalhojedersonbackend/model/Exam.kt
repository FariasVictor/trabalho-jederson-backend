package trabalho.trabalhojedersonbackend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import trabalho.trabalhojedersonbackend.enums.ExamStatusEnum

import java.time.LocalDateTime
import javax.persistence.CascadeType

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Enumerated
import javax.persistence.EnumType
import javax.persistence.FetchType
import javax.persistence.OneToMany

@Entity
data class Exam(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,

        var examCompletedDate: LocalDateTime?,

        var examRequestedDateTime: LocalDateTime?,

        val type: String,

        @Enumerated(EnumType.STRING)
        var status: ExamStatusEnum?,

        @JsonIgnore
        @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        var examData: List<ExamData>?,

        @ManyToOne
        val patient: Patient,

        @ManyToOne
        val doctor: Doctor,

        @ManyToOne
        val clinic: Clinic) {

}
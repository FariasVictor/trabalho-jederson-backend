package trabalho.trabalhojedersonbackend.model

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "exam_data")
data class ExamData (

        @ManyToOne
        val key: String,

        @ManyToOne
        val value: String,

        @OneToOne
        val examId: Long) {
}
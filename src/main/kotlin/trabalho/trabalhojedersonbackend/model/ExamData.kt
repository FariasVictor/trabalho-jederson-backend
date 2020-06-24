package trabalho.trabalhojedersonbackend.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "exam_data")
data class ExamData (

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        @Column(length = 20, nullable = true)
        val key: String,

        @Column(length = 250, nullable = true)
        val value: String,

        val examId: Long) {
}
package trabalho.trabalhojedersonbackend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "exam_data")
data class ExamData (

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,

        @Column(length = 20, nullable = false)
        var key: String?,

        @Column(length = 250, nullable = false)
        var value: String?,

        @JsonIgnore
        @ManyToOne
        var exam: Exam?) {
        constructor() : this(null, null, null, null)
}
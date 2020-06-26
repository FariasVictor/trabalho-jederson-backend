package trabalho.trabalhojedersonbackend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Doctor(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = -1,
        val name: String,
        val phone: String,

        @OneToOne(cascade = [CascadeType.ALL])
        @JoinColumn(nullable=false)
        val address: Address?,

        val crm: String,

        @JsonIgnore
        @OneToMany(mappedBy = "doctor", cascade = [CascadeType.ALL])
        val exams:List<Exam>?,

        @JsonIgnore
        @OneToMany(mappedBy = "doctor", cascade = [CascadeType.ALL])
        val orders:List<Order>?

        ) {
}
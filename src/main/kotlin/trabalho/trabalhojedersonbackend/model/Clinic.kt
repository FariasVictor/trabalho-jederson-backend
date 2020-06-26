package trabalho.trabalhojedersonbackend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Clinic(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = -1,
        val name: String,
        val phone: String,

        @OneToOne(cascade = [CascadeType.ALL])
        val address: Address?,

        val cnpj: String,

        @JsonIgnore
        @OneToMany(mappedBy = "clinic", cascade = [CascadeType.ALL])
        val exams: List<Exam>?,

        @JsonIgnore
        @OneToMany(mappedBy = "clinic", cascade = [CascadeType.ALL])
        val orders: List<Order>?

) {

}
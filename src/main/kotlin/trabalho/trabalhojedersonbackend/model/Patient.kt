package trabalho.trabalhojedersonbackend.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import javax.persistence.*

@Entity
data class Patient(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,

        @Column(length=11, nullable = false)
        val cpf: String,

        @Column(nullable = false)
        val name: String,

        @Column(length = 11)
        val phone: String,

        @Column(nullable = false)
        @JsonFormat(pattern = "yyyy-MM-dd")
        val birthDate: LocalDate,

        @Column(nullable = false)
        val insuranceNumber: String?,

        @OneToOne(cascade = [CascadeType.ALL])
        val address: Address?

) : Identifiable(id, name, phone, address) {

}

package trabalho.trabalhojedersonbackend.model

import org.hibernate.validator.constraints.br.CPF
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Patient(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        @CPF
        @Column(length=11, nullable = false)
        val cpf: String,

        @Column(nullable = false)
        val name: String,

        @Column(length = 11)
        val phone: String,

        @DateTimeFormat(style = "dd/mm/yyyy")
        val birthDate: LocalDateTime,

        @Column(nullable = false)
        val insuranceNumber: String?,

        @OneToOne(cascade = [CascadeType.ALL])
        val address: Address

) : Identifiable(id, name, phone, address) {

}

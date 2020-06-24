package trabalho.trabalhojedersonbackend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.NoArgsConstructor
import org.hibernate.validator.constraints.br.CPF
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import javax.persistence.*

@NoArgsConstructor
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

        val birthDate: LocalDate,

        @Column(nullable = false)
        val insuranceNumber: String,

        @OneToOne(cascade = [CascadeType.ALL])
        val address: Address,

        @JsonIgnore
        @OneToMany(mappedBy = "patient", cascade = [CascadeType.ALL])
        val exams:List<Exam>?,

        @JsonIgnore
        @OneToMany(mappedBy = "patient", cascade = [CascadeType.ALL])
        val orders:List<Order>?

) {

}

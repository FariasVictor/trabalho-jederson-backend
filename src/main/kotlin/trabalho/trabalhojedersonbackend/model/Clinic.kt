package trabalho.trabalhojedersonbackend.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Clinic(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1,
        val name: String,
        val phone: String,
        val address: Address,
        val cnpj: String
) :Identifiable(id, name, phone, address) {

}
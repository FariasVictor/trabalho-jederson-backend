package trabalho.trabalhojedersonbackend.model

import javax.persistence.*

@Entity
class Clinic(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1,
        val name: String,
        val phone: String,
        @OneToOne(cascade = [CascadeType.ALL])
        val address: Address,
        val cnpj: String
) :Identifiable(id, name, phone, address) {

}